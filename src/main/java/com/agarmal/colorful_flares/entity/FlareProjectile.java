package com.agarmal.colorful_flares.entity;

import com.agarmal.colorful_flares.block.AllBlocks;
import com.agarmal.colorful_flares.enums.FlareColor;
import com.agarmal.colorful_flares.particle.AllParticles;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;

public class FlareProjectile extends ThrowableItemProjectile {
    private BlockPos previousPos = null;
    private boolean canDamage = true;
    private long spawnTime;
    private boolean placeLights = true;

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final double MIN_SPEED = 0.2;
    private static final Direction[] DIRECTION_CHECK_ORDER = {
            Direction.UP,
            Direction.DOWN,
            Direction.NORTH,
            Direction.SOUTH,
            Direction.WEST,
            Direction.EAST
    };

    public FlareProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.spawnTime = this.level().getGameTime();
    }

    public FlareProjectile(Level pLevel) {
        super(AllEntities.FLARE_PROJECTILE.get(), pLevel);
        this.spawnTime = this.level().getGameTime();
    }

    public FlareProjectile(Level pLevel, LivingEntity pShooter) {
        super(AllEntities.FLARE_PROJECTILE.get(), pShooter, pLevel);
        this.spawnTime = this.level().getGameTime();
    }

    public FlareProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel, LivingEntity pShooter) {
        super(pEntityType, pShooter, pLevel);
        this.spawnTime = this.level().getGameTime();
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.getEntity() instanceof Player) {
            this.remove(RemovalReason.KILLED);
            return true;
        }
        return super.hurt(pSource, pAmount);
    }

    @Override
    public boolean isAttackable() {
        return true;
    }

    public void generateParticles(FlareColor flareColor) {
        if (!isUnderWater() && this.level().isClientSide) {
            if (random.nextBoolean()) {
                Vec3 pos = this.position();
                ParticleOptions particleOptions = ParticleTypes.CAMPFIRE_SIGNAL_SMOKE;
                if (flareColor != null) {
                    switch (flareColor) {
                        case WHITE -> particleOptions = AllParticles.WHITE_FLARE_SMOKE.get();
                        case LIGHT_GRAY -> particleOptions = AllParticles.LIGHT_GRAY_FLARE_SMOKE.get();
                        case RED -> particleOptions = AllParticles.RED_FLARE_SMOKE.get();
                        case ORANGE -> particleOptions = AllParticles.ORANGE_FLARE_SMOKE.get();
                        case YELLOW -> particleOptions = AllParticles.YELLOW_FLARE_SMOKE.get();
                        case LIME -> particleOptions = AllParticles.LIME_FLARE_SMOKE.get();
                        case GREEN -> particleOptions = AllParticles.GREEN_FLARE_SMOKE.get();
                        case CYAN -> particleOptions = AllParticles.CYAN_FLARE_SMOKE.get();
                        case LIGHT_BLUE -> particleOptions = AllParticles.LIGHT_BLUE_FLARE_SMOKE.get();
                        case BLUE -> particleOptions = AllParticles.BLUE_FLARE_SMOKE.get();
                        case PURPLE -> particleOptions = AllParticles.PURPLE_FLARE_SMOKE.get();
                        case MAGENTA -> particleOptions = AllParticles.MAGENTA_FLARE_SMOKE.get();
                        case PINK -> particleOptions = AllParticles.PINK_FLARE_SMOKE.get();
                    }
                } else {
                    LOGGER.info("No color selected, falling back to CAMPFIRE_SIGNAL_SMOKE!");
                }

                this.level().addParticle(particleOptions, pos.x, pos.y, pos.z, 0.0f, 0.25f, 0.0f);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            checkGroundState();
            removeLightBlock();
            if (this.placeLights) { placeLightBlock(); }

            // Apply buoyancy if in water
            if (this.isUnderWater()) {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.99, 0.8, 0.99).add(0, 0.04, 0));
            }

            if ((this.level().getGameTime() - this.spawnTime) > (120 * 20) || this.isOnFire()) {
                this.remove(RemovalReason.UNLOADED_TO_CHUNK);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!this.level().isClientSide && this.canDamage) { // Logic taken from SmallFireball
            Entity hitEntity = pResult.getEntity();
            Entity shooter = this.getOwner();

            int i = hitEntity.getRemainingFireTicks(); // Store previous onFire ticks
            hitEntity.setSecondsOnFire(3);
            if (!hitEntity.hurt(this.damageSources().mobAttack((LivingEntity) shooter), 2.0f)) { // Try to hurt
                hitEntity.setRemainingFireTicks(i); // Revert fire ticks if not success!
            } else if (shooter instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity) shooter, hitEntity); // Apply effects...
            }

            placeLights = false;
            removeLightBlock();
            this.remove(RemovalReason.KILLED);
        }
    }

    private void checkGroundState() {
        BlockPos pos = this.blockPosition().below();
        BlockState stateBelow = this.level().getBlockState(pos);
        if (!stateBelow.isAir() && stateBelow.isSolidRender(this.level(), pos) && this.getDeltaMovement().length() <= MIN_SPEED) {
            this.setDeltaMovement(Vec3.ZERO);
            this.setNoGravity(true);
            this.canDamage = false;
        } else {
            this.setNoGravity(false);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            BlockPos blockPos = pResult.getBlockPos();
            Vec3 velocity = this.getDeltaMovement();

            if (velocity.length() > MIN_SPEED || pResult.getDirection() != Direction.UP) {
                // Get the normal of the hit face
                Vec3 normal = Vec3.atLowerCornerOf(pResult.getDirection().getNormal());
                // Reflect the velocity vector off the surface
                Vec3 reflection = velocity.subtract(normal.scale(2 * velocity.dot(normal)));
                // Apply the reflected velocity, with some reduction to simulate energy loss
                this.setDeltaMovement(reflection.scale(0.5));
                // Ensure the projectile has impulse to make the physics update correctly
                this.hasImpulse = true;
                this.canDamage = true;
            }
        }
    }

    @Override
    public void remove(RemovalReason pReason) {
        removeLightBlock();
        super.remove(pReason);
    }

    @Override
    protected void removeAfterChangingDimensions() {
        removeLightBlock();
        super.removeAfterChangingDimensions();
    }

    private void removeLightBlock() {
        if (previousPos != null) {
            // Remove the previous light block:
            if (this.level().getBlockState(previousPos).getBlock() == AllBlocks.FLARE_LIGHT_BLOCK.get()) {
                this.level().setBlock(previousPos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }

    private void placeLightBlock() {
        BlockPos currentPos = blockPosition();

        if (this.level().getBlockState(currentPos).isAir()) { // Place a new light block at the current position
            this.level().setBlock(currentPos, AllBlocks.FLARE_LIGHT_BLOCK.get().defaultBlockState(), 3);
            previousPos = currentPos;
        } else {
            for (Direction direction : DIRECTION_CHECK_ORDER) { // Check all the directions to try and place light.
                BlockPos checkPos = currentPos.relative(direction);
                if (this.level().getBlockState(checkPos).isAir()) {
                    this.level().setBlock(checkPos, AllBlocks.FLARE_LIGHT_BLOCK.get().defaultBlockState(), 3);
                    previousPos = checkPos;
                    break;
                }
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putLong("SpawnTime", this.spawnTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("SpawnTime")) {
            this.spawnTime = pCompound.getLong("SpawnTime");
        }
    }
}

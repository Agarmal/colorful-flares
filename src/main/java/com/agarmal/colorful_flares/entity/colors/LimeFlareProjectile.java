package com.agarmal.colorful_flares.entity.colors;

import com.agarmal.colorful_flares.entity.AllEntities;
import com.agarmal.colorful_flares.entity.FlareProjectile;
import com.agarmal.colorful_flares.enums.FlareColor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;

public class LimeFlareProjectile extends FlareProjectile {
    public LimeFlareProjectile(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LimeFlareProjectile(Level pLevel) {
        super(pLevel);
    }

    public LimeFlareProjectile(Level pLevel, LivingEntity pShooter) {
        super(AllEntities.LIME_FLARE_PROJECTILE.get(), pLevel, pShooter);
    }

    @Override
    public void tick() {
        super.tick();
        this.generateParticles(FlareColor.LIME);
    }
}

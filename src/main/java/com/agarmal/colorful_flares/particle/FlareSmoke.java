package com.agarmal.colorful_flares.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FlareSmoke extends TextureSheetParticle {
    public FlareSmoke(ClientLevel pLevel, double pX, double pY, double pZ,
                      SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed, float red, float green, float blue) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);

        this.scale(5.0F);
        this.setSize(0.25F, 0.25F);
        this.setAlpha(0.9f);
        this.lifetime = this.random.nextInt(50) + 280;

        this.gravity = 3.0E-6F;
        this.xd = pXSpeed;
        this.yd = pYSpeed + (double)(this.random.nextFloat() / 500.0F);
        this.zd = pZSpeed;
        this.setSpriteFromAge(spriteSet);

        this.rCol = red;
        this.gCol = green;
        this.bCol = blue;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
            this.xd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1));
            this.zd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1));
            this.yd -= (double)this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.age >= this.lifetime - 60 && this.alpha > 0.01F) {
                this.alpha -= 0.015F;
            }
        } else {
            this.remove();
        }
    }

    @Override
    public ParticleRenderType getRenderType() { return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT; }

    // Color factory types:
    // WHITE, LIGHT_GRAY, RED, ORANGE, YELLOW, LIME, GREEN, CYAN, LIGHT_BLUE, BLUE, PURPLE, MAGENTA, PINK
    @OnlyIn(Dist.CLIENT)
    public static class WhiteFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public WhiteFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.98f, 1f, 1f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class LightGrayFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public LightGrayFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.62f, 0.62f, 0.6f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class RedFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public RedFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.69f, 0.18f, 0.15f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class OrangeFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public OrangeFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.98f, 0.5f, 0.11f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class YellowFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public YellowFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.98f, 0.85f, 0.24f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class LimeFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public LimeFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.5f, 0.78f, 0.12f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class GreenFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public GreenFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.37f, 0.49f, 0.09f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class CyanFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public CyanFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.09f, 0.61f, 0.61f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class LightBlueFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public LightBlueFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.23f, 0.7f, 0.85f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class BlueFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public BlueFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.24f, 0.27f, 0.67f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class PurpleFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public PurpleFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.54f, 0.2f, 0.72f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class MagentaFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public MagentaFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.78f, 0.3f, 0.74f);
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class PinkFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public PinkFactory(SpriteSet spriteSet) { this.spriteSet = spriteSet; }
        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new FlareSmoke(level, x, y, z, this.spriteSet, dx, dy, dz, 0.95f, 0.55f, 0.67f);
        }
    }
}

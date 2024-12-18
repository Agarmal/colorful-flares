package com.agarmal.colorful_flares.particle;

import com.agarmal.colorful_flares.ColorfulFlares;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllParticles {
    public static DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ColorfulFlares.MOD_ID);

    // All colors for FlareSmoke
    // WHITE, LIGHT_GRAY, RED, ORANGE, YELLOW, LIME, GREEN, CYAN, LIGHT_BLUE, BLUE, PURPLE, MAGENTA, PINK
    public static final RegistryObject<SimpleParticleType> WHITE_FLARE_SMOKE =
            PARTICLE_TYPES.register("white_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LIGHT_GRAY_FLARE_SMOKE =
            PARTICLE_TYPES.register("light_gray_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> RED_FLARE_SMOKE =
            PARTICLE_TYPES.register("red_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ORANGE_FLARE_SMOKE =
            PARTICLE_TYPES.register("orange_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> YELLOW_FLARE_SMOKE =
            PARTICLE_TYPES.register("yellow_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LIME_FLARE_SMOKE =
            PARTICLE_TYPES.register("lime_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> GREEN_FLARE_SMOKE =
            PARTICLE_TYPES.register("green_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> CYAN_FLARE_SMOKE =
            PARTICLE_TYPES.register("cyan_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> LIGHT_BLUE_FLARE_SMOKE =
            PARTICLE_TYPES.register("light_blue_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> BLUE_FLARE_SMOKE =
            PARTICLE_TYPES.register("blue_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> PURPLE_FLARE_SMOKE =
            PARTICLE_TYPES.register("purple_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> MAGENTA_FLARE_SMOKE =
            PARTICLE_TYPES.register("magenta_flare_smoke", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> PINK_FLARE_SMOKE =
            PARTICLE_TYPES.register("pink_flare_smoke", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}

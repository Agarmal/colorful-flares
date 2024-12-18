package com.agarmal.colorful_flares.entity;

import com.agarmal.colorful_flares.ColorfulFlares;
import com.agarmal.colorful_flares.entity.colors.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ColorfulFlares.MOD_ID);

    public static final RegistryObject<EntityType<FlareProjectile>> FLARE_PROJECTILE =
            ENTITY_TYPES.register("flare_projectile", () -> EntityType.Builder.<FlareProjectile>of(FlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("flare_projectile"));
    public static final RegistryObject<EntityType<WhiteFlareProjectile>> WHITE_FLARE_PROJECTILE =
            ENTITY_TYPES.register("white_flare_projectile", () -> EntityType.Builder.<WhiteFlareProjectile>of(WhiteFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("white_flare_projectile"));
    public static final RegistryObject<EntityType<LightGrayFlareProjectile>> LIGHT_GRAY_FLARE_PROJECTILE =
            ENTITY_TYPES.register("light_gray_flare_projectile", () -> EntityType.Builder.<LightGrayFlareProjectile>of(LightGrayFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("light_gray_flare_projectile"));
    public static final RegistryObject<EntityType<RedFlareProjectile>> RED_FLARE_PROJECTILE =
            ENTITY_TYPES.register("red_flare_projectile", () -> EntityType.Builder.<RedFlareProjectile>of(RedFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("red_flare_projectile"));
    public static final RegistryObject<EntityType<OrangeFlareProjectile>> ORANGE_FLARE_PROJECTILE =
            ENTITY_TYPES.register("orange_flare_projectile", () -> EntityType.Builder.<OrangeFlareProjectile>of(OrangeFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("orange_flare_projectile"));
    public static final RegistryObject<EntityType<YellowFlareProjectile>> YELLOW_FLARE_PROJECTILE =
            ENTITY_TYPES.register("yellow_flare_projectile", () -> EntityType.Builder.<YellowFlareProjectile>of(YellowFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("yellow_flare_projectile"));
    public static final RegistryObject<EntityType<LimeFlareProjectile>> LIME_FLARE_PROJECTILE =
            ENTITY_TYPES.register("lime_flare_projectile", () -> EntityType.Builder.<LimeFlareProjectile>of(LimeFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("lime_flare_projectile"));
    public static final RegistryObject<EntityType<GreenFlareProjectile>> GREEN_FLARE_PROJECTILE =
            ENTITY_TYPES.register("green_flare_projectile", () -> EntityType.Builder.<GreenFlareProjectile>of(GreenFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("green_flare_projectile"));
    public static final RegistryObject<EntityType<CyanFlareProjectile>> CYAN_FLARE_PROJECTILE =
            ENTITY_TYPES.register("cyan_flare_projectile", () -> EntityType.Builder.<CyanFlareProjectile>of(CyanFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("cyan_flare_projectile"));
    public static final RegistryObject<EntityType<LightBlueFlareProjectile>> LIGHT_BLUE_FLARE_PROJECTILE =
            ENTITY_TYPES.register("light_blue_flare_projectile", () -> EntityType.Builder.<LightBlueFlareProjectile>of(LightBlueFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("light_blue_flare_projectile"));
    public static final RegistryObject<EntityType<BlueFlareProjectile>> BLUE_FLARE_PROJECTILE =
            ENTITY_TYPES.register("blue_flare_projectile", () -> EntityType.Builder.<BlueFlareProjectile>of(BlueFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("blue_flare_projectile"));
    public static final RegistryObject<EntityType<PurpleFlareProjectile>> PURPLE_FLARE_PROJECTILE =
            ENTITY_TYPES.register("purple_flare_projectile", () -> EntityType.Builder.<PurpleFlareProjectile>of(PurpleFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("purple_flare_projectile"));
    public static final RegistryObject<EntityType<MagentaFlareProjectile>> MAGENTA_FLARE_PROJECTILE =
            ENTITY_TYPES.register("magenta_flare_projectile", () -> EntityType.Builder.<MagentaFlareProjectile>of(MagentaFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("magenta_flare_projectile"));
    public static final RegistryObject<EntityType<PinkFlareProjectile>> PINK_FLARE_PROJECTILE =
            ENTITY_TYPES.register("pink_flare_projectile", () -> EntityType.Builder.<PinkFlareProjectile>of(PinkFlareProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("pink_flare_projectile"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

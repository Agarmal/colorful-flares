package com.agarmal.colorful_flares.item;

import com.agarmal.colorful_flares.ColorfulFlares;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ColorfulFlares.MOD_ID);

    public static final RegistryObject<Item> WHITE_FLARE = ITEMS.register("white_flare",
            () -> new WhiteFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_GRAY_FLARE = ITEMS.register("light_gray_flare",
            () -> new LightGrayFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> GRAY_FLARE = ITEMS.register("gray_flare",
            () -> new GrayFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_FLARE = ITEMS.register("black_flare",
            () -> new BlackFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> BROWN_FLARE = ITEMS.register("brown_flare",
            () -> new BrownFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> RED_FLARE = ITEMS.register("red_flare",
            () -> new RedFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_FLARE = ITEMS.register("orange_flare",
            () -> new OrangeFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_FLARE = ITEMS.register("yellow_flare",
            () -> new YellowFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> LIME_FLARE = ITEMS.register("lime_flare",
            () -> new LimeFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_FLARE = ITEMS.register("green_flare",
            () -> new GreenFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> CYAN_FLARE = ITEMS.register("cyan_flare",
            () -> new CyanFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_BLUE_FLARE = ITEMS.register("light_blue_flare",
            () -> new LightBlueFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_FLARE = ITEMS.register("blue_flare",
            () -> new BlueFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> PURPLE_FLARE = ITEMS.register("purple_flare",
            () -> new PurpleFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> MAGENTA_FLARE = ITEMS.register("magenta_flare",
            () -> new MagentaFlareItem(new Item.Properties()));
    public static final RegistryObject<Item> PINK_FLARE = ITEMS.register("pink_flare",
            () -> new PinkFlareItem(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

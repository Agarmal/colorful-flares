package com.agarmal.colorful_flares.block;

import com.agarmal.colorful_flares.ColorfulFlares;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllBlocks {
    public static DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ColorfulFlares.MOD_ID);

    public static final RegistryObject<Block> FLARE_LIGHT_BLOCK = BLOCKS.register("flare_light_block",
            FlareLightBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

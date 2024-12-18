package com.agarmal.colorful_flares.block;

import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class FlareLightBlock extends Block {
    public FlareLightBlock() {
        super(AirBlock.Properties.of()
                .noCollission()
                .instabreak()
                .lightLevel((state) -> 15)
                .noOcclusion());
    }

    @Override
    protected boolean isAir(BlockState state) {
        return true;
    }
}

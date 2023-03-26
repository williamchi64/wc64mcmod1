package com.github.williamchi64.minecraftmod1.block.constant;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public interface BlocksConstant {
    interface NAME {
        String PUDDING_BLOCK = "pudding_block";
        String ORIGINITE_PRIME_BLOCK = "originite_prime_block";
    }

    interface PROPERTIES {
        Supplier<Block> PUDDING_BLOCK = () -> new Block(BlockBehaviour.Properties
                .of(Material.CAKE)
                .strength(1f)
                .requiresCorrectToolForDrops());
        Supplier<Block> ORIGINITE_PRIME_BLOCK = () -> new DropExperienceBlock(BlockBehaviour.Properties
                .of(Material.STONE)
                .strength(10f)
                .requiresCorrectToolForDrops(),
                UniformInt.of(2, 6));
    }
}

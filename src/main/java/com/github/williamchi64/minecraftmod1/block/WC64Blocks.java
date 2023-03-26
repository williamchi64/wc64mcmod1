package com.github.williamchi64.minecraftmod1.block;

import com.github.williamchi64.minecraftmod1.WC64MCMod;
import com.github.williamchi64.minecraftmod1.block.constant.BlocksConstant;
import com.github.williamchi64.minecraftmod1.item.WC64Items;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class WC64Blocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "wc64mcmod1" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WC64MCMod.MOD_ID);
    // Creates a new Block with the id "wc64mcmod1:example_block", combining the namespace and path
    public static final RegistryObject<Block> PUDDING_BLOCK = registerBlock(BlocksConstant.NAME.PUDDING_BLOCK, BlocksConstant.PROPERTIES.PUDDING_BLOCK);
    public static final RegistryObject<Block> ORIGINITE_PRIME_BLOCK = registerBlock(BlocksConstant.NAME.ORIGINITE_PRIME_BLOCK, BlocksConstant.PROPERTIES.ORIGINITE_PRIME_BLOCK);

    public static void register(final IEventBus eventBus) {
        WC64Blocks.BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> properties) {
        final RegistryObject<T> block = WC64Blocks.BLOCKS.register(name, properties);
        registerBlockItem(name, block);
        return block;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(final String name, final RegistryObject<T> block) {
        return WC64Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}

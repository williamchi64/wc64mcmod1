package com.github.williamchi64.minecraftmod1.event.constant;

import com.github.williamchi64.minecraftmod1.block.WC64Blocks;
import com.github.williamchi64.minecraftmod1.item.WC64Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public interface TabsConstant {
    interface ITEM {
        String NAME = "mod_item_tab";
        String TRANSLATE_NAME_KEY = "wc64tab.mod_item_tab";
        Consumer<CreativeModeTab.Builder> PROPERTIES = builder -> builder
                .icon(() -> new ItemStack(WC64Items.PUDDING.get()))
                .title(Component.translatable(TRANSLATE_NAME_KEY));
    }

    interface BLOCK {
        String NAME = "mod_block_tab";
        String TRANSLATE_NAME_KEY = "wc64tab.mod_block_tab";
        Consumer<CreativeModeTab.Builder> PROPERTIES = builder -> builder
                .icon(() -> new ItemStack(WC64Blocks.PUDDING_BLOCK.get()))
                .title(Component.translatable(TRANSLATE_NAME_KEY));
    }
}

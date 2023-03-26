package com.github.williamchi64.minecraftmod1.event;

import com.github.williamchi64.minecraftmod1.WC64MCMod;
import com.github.williamchi64.minecraftmod1.event.constant.TabsConstant;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WC64MCMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WC64Tabs {
    public static CreativeModeTab ITEM_TAB;
    public static CreativeModeTab BLOCK_TAB;

    @SubscribeEvent
    public static void registerCreativeModesTabs(final CreativeModeTabEvent.Register event) {
        final ResourceLocation itemResourceLocation = new ResourceLocation(WC64MCMod.MOD_ID, TabsConstant.ITEM.NAME);
        WC64Tabs.ITEM_TAB = event.registerCreativeModeTab(itemResourceLocation, TabsConstant.ITEM.PROPERTIES);
        final ResourceLocation blockResourceLocation = new ResourceLocation(WC64MCMod.MOD_ID, TabsConstant.BLOCK.NAME);
        WC64Tabs.BLOCK_TAB = event.registerCreativeModeTab(blockResourceLocation, TabsConstant.BLOCK.PROPERTIES);
    }
}

package com.github.williamchi64.minecraftmod1;

import com.github.williamchi64.minecraftmod1.block.WC64Blocks;
import com.github.williamchi64.minecraftmod1.item.WC64Items;
import com.github.williamchi64.minecraftmod1.event.WC64Tabs;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WC64MCMod.MOD_ID)
public class WC64MCMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "wc64mcmod1";
    // Directly reference a slf4j logger
    private static final Logger LOG = LogUtils.getLogger();
    public WC64MCMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the Deferred Register to the mod event bus so items get registered
        WC64Items.register(modEventBus);
        // Register the Deferred Register to the mod event bus so blocks get registered
        WC64Blocks.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOG.info("HELLO FROM COMMON SETUP");
        LOG.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void addCreative(final CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS || event.getTab() == WC64Tabs.ITEM_TAB) {
            event.accept(WC64Items.PUDDING);
            event.accept(WC64Items.ORIGINITE_PRIME);
        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS || event.getTab() == WC64Tabs.BLOCK_TAB) {
            event.accept(WC64Blocks.PUDDING_BLOCK);
            event.accept(WC64Blocks.ORIGINITE_PRIME_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOG.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOG.info("HELLO FROM CLIENT SETUP");
            LOG.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}

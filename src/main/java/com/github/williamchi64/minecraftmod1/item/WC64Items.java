package com.github.williamchi64.minecraftmod1.item;

import com.github.williamchi64.minecraftmod1.WC64MCMod;
import com.github.williamchi64.minecraftmod1.item.constant.ItemsConstant;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WC64Items {
    // Create a Deferred Register to hold Items which will all be registered under the "wc64mcmod1" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WC64MCMod.MOD_ID);
    // Creates a new BlockItem with the id "wc64mcmod1:example_block", combining the namespace and path
    public static final RegistryObject<Item> PUDDING = WC64Items.ITEMS.register(ItemsConstant.NAME.PUDDING, ItemsConstant.PROPERTIES.PUDDING);
    public static final RegistryObject<Item> ORIGINITE_PRIME = WC64Items.ITEMS.register(ItemsConstant.NAME.ORIGINITE_PRIME, ItemsConstant.PROPERTIES.ORIGINITE_PRIME);

    public static void register(final IEventBus eventBus) {
        WC64Items.ITEMS.register(eventBus);
    }
}

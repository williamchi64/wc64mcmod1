package com.github.williamchi64.minecraftmod1.item.constant;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public interface ItemsConstant {
    interface NAME {
        String PUDDING = "pudding";
        String ORIGINITE_PRIME = "originite_prime";
    }

    interface PROPERTIES {
        Supplier<Item> PUDDING = () -> new Item(new Item.Properties()
                .stacksTo(5)
                .rarity(Rarity.EPIC));
        Supplier<Item> ORIGINITE_PRIME = () -> new Item(new Item.Properties()
                .stacksTo(999)
                .rarity(Rarity.EPIC));
    }
}

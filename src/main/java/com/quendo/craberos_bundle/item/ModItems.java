package com.quendo.craberos_bundle.item;

import com.quendo.craberos_bundle.CraberosBundle;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_RUBBER = registerItem("raw_rubber", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CraberosBundle.MOD_ID , name), item);
    }

    public static void registerModItems() {
        CraberosBundle.LOGGER.info("Registering Mod Items for " + CraberosBundle.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_RUBBER);
        });
    }
}

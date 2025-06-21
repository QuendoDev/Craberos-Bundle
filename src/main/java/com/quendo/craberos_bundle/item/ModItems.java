package com.quendo.craberos_bundle.item;

import com.quendo.craberos_bundle.CraberosBundle;
import com.quendo.craberos_bundle.item.custom.RubberExtractorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_RUBBER = registerItem("raw_rubber", new Item(new Item.Settings()));
    public static final Item RUBBER = registerItem("rubber", new Item(new Item.Settings()));

    public static final Item RUBBER_EXTRACTOR = registerItem("rubber_extractor",
            new RubberExtractorItem(new Item.Settings().maxDamage(238)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CraberosBundle.MOD_ID , name), item);
    }

    public static void registerModItems() {
        CraberosBundle.LOGGER.info("Registering Mod Items for " + CraberosBundle.MOD_ID);
    }
}

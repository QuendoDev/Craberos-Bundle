package com.quendo.craberos_bundle.item;

import com.quendo.craberos_bundle.CraberosBundle;
import com.quendo.craberos_bundle.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup CRABEROS_BUNDLE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CraberosBundle.MOD_ID, "craberos_bundle_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_RUBBER))
                    .displayName(Text.translatable("itemgroup.craberos_bundle.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_RUBBER);
                        entries.add(ModItems.RUBBER);

                        entries.add(ModItems.RUBBER_EXTRACTOR);
                    }).build());

    public static final ItemGroup CRABEROS_BUNDLE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CraberosBundle.MOD_ID, "craberos_bundle_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.RAW_RUBBER_BLOCK))
                    .displayName(Text.translatable("itemgroup.craberos_bundle.blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAW_RUBBER_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        CraberosBundle.LOGGER.info("Registering Item Groups for " + CraberosBundle.MOD_ID);
    }
}

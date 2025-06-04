package com.quendo.craberos_bundle.block;

import com.quendo.craberos_bundle.CraberosBundle;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RAW_RUBBER_BLOCK = registerBlock("raw_rubber_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.SPONGE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CraberosBundle.MOD_ID, name), block);
    }

    //In AbstractBlock.Settings.create(), there is an .requiredTool() method that can be used to specify
    // that a block requires a specific tool to be mined, such as a pickaxe or shovel.


    // For ores or blocks that drop experience, new ExperienceDroppingBlockItem (UniformIntProvider.create(2, 5),
    // AbstractBlock.Settings.create()) is used instead of BlockItem.

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CraberosBundle.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        CraberosBundle.LOGGER.info("Registering Mod Blocks for " + CraberosBundle.MOD_ID);
    }
}

package com.quendo.craberos_bundle.item.custom;

import com.quendo.craberos_bundle.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import static net.minecraft.block.Block.dropStack;

public class RubberExtractorItem extends Item {

    private static final Block RUBBER_TREE_LOG =
            Blocks.JUNGLE_LOG; //TODO: Replace with the actual block you want to use

    public RubberExtractorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (clickedBlock == RUBBER_TREE_LOG) {
            if(!world.isClient() && context.getPlayer() != null) {
                world.setBlockState(context.getBlockPos(), Blocks.STRIPPED_JUNGLE_LOG.getDefaultState());

                // Drop a random amount of raw rubber between 1 and 3.
                dropStack(world, context.getBlockPos(),
                        new ItemStack(ModItems.RAW_RUBBER,
                                world.getRandom().nextInt(3) + 1));

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null,
                        context.getBlockPos(),
                        SoundEvents.ITEM_AXE_STRIP,
                        SoundCategory.BLOCKS);

                return ActionResult.SUCCESS;
            }
        }

        return super.useOnBlock(context);
    }
}

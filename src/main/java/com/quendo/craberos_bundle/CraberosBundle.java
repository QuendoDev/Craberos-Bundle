package com.quendo.craberos_bundle;

import com.quendo.craberos_bundle.block.ModBlocks;
import com.quendo.craberos_bundle.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CraberosBundle implements ModInitializer {
	public static final String MOD_ID = "craberos_bundle";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerBlocks();
	}
}
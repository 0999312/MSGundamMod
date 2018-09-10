package com.spaceboyross.gundam;

import com.spaceboyross.gundam.blocks.LunaTitaniumBlock;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GundamBlocks {
	
	@GameRegistry.ObjectHolder("gundam:luna_titanium_block")
	public static LunaTitaniumBlock lunaTitaniumBlock;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		GundamBlocks.lunaTitaniumBlock.initModel();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initItemModels() {}
}
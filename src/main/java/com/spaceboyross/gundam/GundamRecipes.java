package com.spaceboyross.gundam;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GundamRecipes {
	public static void init() {
		GameRegistry.addSmelting(GundamBlocks.lunaTitaniumOre,new ItemStack(GundamItems.lunaTitaniumIngot,3),0.2f);
		
		GameRegistry.addSmelting(GundamItems.lunaTitaniumIngot,new ItemStack(GundamItems.gundariumAlphaIngot),0.2f);
		GameRegistry.addSmelting(GundamItems.gundariumAlphaIngot,new ItemStack(GundamItems.gundariumBetaIngot),0.2f);
		GameRegistry.addSmelting(GundamItems.gundariumBetaIngot,new ItemStack(GundamItems.gundariumGammaIngot),0.2f);
		GameRegistry.addSmelting(GundamItems.gundariumGammaIngot,new ItemStack(GundamItems.gundariumEpsilonIngot),0.2f);
		
		GameRegistry.addSmelting(GameRegistry.makeItemStack("minecraft:iron",0,1,"").getItem(),new ItemStack(GundamItems.steelIngot),0.2f);
		GameRegistry.addSmelting(GundamItems.steelIngot,new ItemStack(GundamItems.superHardSteelIngot,1),0.2f);
	}
}
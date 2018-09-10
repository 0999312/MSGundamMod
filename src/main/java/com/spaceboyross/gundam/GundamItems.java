package com.spaceboyross.gundam;

import com.spaceboyross.gundam.items.GControllerItem;
import com.spaceboyross.gundam.items.GundariumAlphaIngotItem;
import com.spaceboyross.gundam.items.GundariumBetaIngotItem;
import com.spaceboyross.gundam.items.GundariumEpsilonIngotItem;
import com.spaceboyross.gundam.items.GundariumGammaIngotItem;
import com.spaceboyross.gundam.items.LunaTitaniumIngotItem;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GundamItems {
	
	@GameRegistry.ObjectHolder("gundam:g_controller")
	public static GControllerItem gController;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_alpha_ingot")
	public static GundariumAlphaIngotItem gundariumAlphaIngot;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_beta_ingot")
	public static GundariumBetaIngotItem gundariumBetaIngot;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_epsilon_ingot")
	public static GundariumEpsilonIngotItem gundariumEpsilonIngot;
	
	@GameRegistry.ObjectHolder("gundam:gundarium_gamma_ingot")
	public static GundariumGammaIngotItem gundariumGammaIngot;
	
	@GameRegistry.ObjectHolder("gundam:luna_titanium_ingot")
	public static LunaTitaniumIngotItem lunaTitaniumIngot;
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		GundamItems.gController.initModel();
		GundamItems.gundariumAlphaIngot.initModel();
		GundamItems.gundariumBetaIngot.initModel();
		GundamItems.gundariumEpsilonIngot.initModel();
		GundamItems.gundariumGammaIngot.initModel();
		GundamItems.lunaTitaniumIngot.initModel();
	}
}
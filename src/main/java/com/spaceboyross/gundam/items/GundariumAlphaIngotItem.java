package com.spaceboyross.gundam.items;

import com.spaceboyross.gundam.GundamMod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GundariumAlphaIngotItem extends Item {

	public GundariumAlphaIngotItem() {
		this.setRegistryName("gundarium_alpha_ingot");
		this.setUnlocalizedName(GundamMod.MODID+".gundarium_alpha_ingot");
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
package com.spaceboyross.gundam.gui.hud;

import com.spaceboyross.gundam.capabilities.interfaces.IHumanCapability;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class MobileSuitHUD extends Gui {
	
	public Minecraft mc;
	public IHumanCapability human;
	public ScaledResolution scaledRes;
	public int width;
	public int height;
	
	public MobileSuitHUD(Minecraft mc,IHumanCapability human) {
		this.mc = mc;
		this.human = human;
		this.scaledRes = new ScaledResolution(mc);
		
		this.width = this.scaledRes.getScaledWidth();
		this.height = this.scaledRes.getScaledHeight();
		
		human.getMS().getMSRegistryEntry().drawHUD(this);
	}
}
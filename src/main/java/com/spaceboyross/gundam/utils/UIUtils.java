package com.spaceboyross.gundam.utils;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;

public class UIUtils {
	public static int calculateButtonWidth(FontRenderer fontRenderer,String name) {
		return 20+fontRenderer.getStringWidth(name);
	}
	
	public static int calculateButtonHeight(FontRenderer fontRenderer) {
		return 10+fontRenderer.FONT_HEIGHT;
	}
	
	public static int calculateButtonWidthI18N(FontRenderer fontRenderer,String key,Object...params) {
		return UIUtils.calculateButtonWidth(fontRenderer,I18n.format(key,params));
	}
	
	public static GuiButton makeButton(FontRenderer fontRenderer,int id,int x,int y,String name) {
		return new GuiButton(id,x,y,UIUtils.calculateButtonWidth(fontRenderer,name),UIUtils.calculateButtonHeight(fontRenderer),name);
	}
	
	public static GuiButton makeButtonI18N(FontRenderer fontRenderer,int id,int x,int y,String key,Object...params) {
		return UIUtils.makeButton(fontRenderer,id,x,y,I18n.format(key,params));
	}
	
	public static int divideScreenWidth(FontRenderer fontRenderer,int screenWidth,String...names) {
		return UIUtils.divideScreenWidth(fontRenderer,0,screenWidth,names);
	}
	
	public static int divideScreenWidth(FontRenderer fontRenderer,int spacing,int screenWidth,String...names) {
		int width = screenWidth;
		int namesWidth = 0;
		for(int i = 0;i < names.length;i++) {
			namesWidth += UIUtils.calculateButtonWidth(fontRenderer,names[i]);
			if((i+1) < names.length) namesWidth += spacing;
		}
		width -= namesWidth;
		return width/2;
	}
	
	public static int divideScreenWidthI18N(FontRenderer fontRenderer,int screenWidth,String...keys) {
		return UIUtils.divideScreenWidthI18N(fontRenderer,0,screenWidth,keys);
	}
	
	public static int divideScreenWidthI18N(FontRenderer fontRenderer,int spacing,int screenWidth,String...keys) {
		String names[] = new String[keys.length];
		for(int i = 0;i < keys.length;i++) names[i] = I18n.format(keys[i]);
		return UIUtils.divideScreenWidth(fontRenderer,spacing,screenWidth,names);
	}
	
	public static int divideScreenHeight(FontRenderer fontRenderer,int screenHeight,int amount) {
		return UIUtils.divideScreenHeight(fontRenderer,0,screenHeight,amount);
	}
	
	public static int divideScreenHeight(FontRenderer fontRenderer,int spacing,int screenHeight,int amount) {
		int height = screenHeight;
		height -= amount*UIUtils.calculateButtonHeight(fontRenderer)+(spacing*(amount-1));
		return height/2;
	}
}
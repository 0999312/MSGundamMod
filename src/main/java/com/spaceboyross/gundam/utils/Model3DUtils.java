package com.spaceboyross.gundam.utils;

import org.lwjgl.opengl.GL11;

import com.spaceboyross.gundam.models.WavefrontObject;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class Model3DUtils {
	
	public static void render(WavefrontObject obj,double x,double y,double z) {
		/*Tessellator tes = Tessellator.getInstance();
		BufferBuilder buff = obj.getBufferBuilder();
		buff.begin(7,DefaultVertexFormats.POSITION_TEX_NORMAL);
		buff.setTranslation(x,y,z);
		obj.putVertices(buff);*/
	}
	
	public static void render(WavefrontObject obj) {
		/*Tessellator tes = Tessellator.getInstance();
		BufferBuilder buff = obj.getBufferBuilder();
		buff.begin(7,DefaultVertexFormats.POSITION_TEX_NORMAL);
		obj.putVertices(buff);
		tes.draw();*/
	}
}
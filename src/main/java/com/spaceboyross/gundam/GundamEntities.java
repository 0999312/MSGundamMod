package com.spaceboyross.gundam;

import com.spaceboyross.gundam.entities.EntityAmuroRay;
import com.spaceboyross.gundam.entities.EntityBrightNoa;
import com.spaceboyross.gundam.entities.EntityCharAznable;
import com.spaceboyross.gundam.entities.EntityDomonKasshu;
import com.spaceboyross.gundam.entities.EntityFullFrontal;
import com.spaceboyross.gundam.entities.EntityMasterAsia;
import com.spaceboyross.gundam.entities.EntityQuattroBajeena;
import com.spaceboyross.gundam.entities.render.RenderAmuroRay;
import com.spaceboyross.gundam.entities.render.RenderBrightNoa;
import com.spaceboyross.gundam.entities.render.RenderCharAznable;
import com.spaceboyross.gundam.entities.render.RenderDomonKasshu;
import com.spaceboyross.gundam.entities.render.RenderFullFrontal;
import com.spaceboyross.gundam.entities.render.RenderMasterAsia;
import com.spaceboyross.gundam.entities.render.RenderQuattroBajeena;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GundamEntities {
	
	public static void init() {
		int id = 1;

		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"amuro_ray"),EntityAmuroRay.class,"AmuroRay",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"bright_noa"),EntityBrightNoa.class,"BrightNoa",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"char_aznable"),EntityCharAznable.class,"CharAznable",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"domon_kasshu"),EntityDomonKasshu.class,"DomonKasshu",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"full_frontal"),EntityFullFrontal.class,"FullFrontal",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"master_asia"),EntityMasterAsia.class,"MasterAsia",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(GundamMod.MODID,"quattro_bajeena"),EntityQuattroBajeena.class,"QuattroBajeena",id++,GundamMod.instance,64,3,true,0x996600,0x00ff00);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityAmuroRay.class,RenderAmuroRay.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityBrightNoa.class,RenderBrightNoa.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityCharAznable.class,RenderCharAznable.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDomonKasshu.class,RenderDomonKasshu.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityFullFrontal.class,RenderFullFrontal.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityMasterAsia.class,RenderMasterAsia.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityQuattroBajeena.class,RenderQuattroBajeena.FACTORY);
	}
}
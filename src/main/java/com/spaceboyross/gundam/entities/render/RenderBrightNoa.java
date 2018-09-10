package com.spaceboyross.gundam.entities.render;

import javax.annotation.Nonnull;

import com.spaceboyross.gundam.entities.EntityAmuroRay;
import com.spaceboyross.gundam.entities.EntityBrightNoa;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBrightNoa extends RenderLiving<EntityBrightNoa> {

	private ResourceLocation texture = new ResourceLocation("gundam:textures/entity/bright_noa.png");
	
	public static final Factory FACTORY = new Factory();
	
	public RenderBrightNoa(RenderManager rendermanagerIn) {
		super(rendermanagerIn,new ModelPlayer(1.0f,false),0.5F);
	}

	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityBrightNoa entity) {
		return this.texture;
	}
	
	public static class Factory implements IRenderFactory<EntityBrightNoa> {
		@Override
		public Render<? super EntityBrightNoa> createRenderFor(RenderManager manager) {
			return new RenderBrightNoa(manager);
		}
	}
}
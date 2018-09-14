package com.spaceboyross.gundam.capabilities.newtype;

import com.spaceboyross.gundam.GundamMod;
import com.spaceboyross.gundam.capabilities.interfaces.INewtypeCapability;
import com.spaceboyross.gundam.capabilities.providers.NewtypeProvider;
import com.spaceboyross.gundam.gui.HumantypeGUI;
import com.spaceboyross.gundam.utils.CapabilityUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class Newtype {
	@CapabilityInject(INewtypeCapability.class)
	public static final Capability<INewtypeCapability> MAX_NEWTYPE_CAPABILITY = null;
	
	public static final EnumFacing DEFAULT_FACING = null;
	
	public static final ResourceLocation ID = new ResourceLocation(GundamMod.MODID,"Newtype");
	
	public static void register() {
		CapabilityManager.INSTANCE.register(INewtypeCapability.class,new Capability.IStorage<INewtypeCapability>() {
			@Override
			public NBTBase writeNBT(Capability<INewtypeCapability> capability,INewtypeCapability instance,EnumFacing side) {
				NBTTagCompound root = new NBTTagCompound();
				root.setBoolean("shownHumantypeMenu",instance.hasShownHumantypeMenu());
				return root;
			}

			@Override
			public void readNBT(Capability<INewtypeCapability> capability,INewtypeCapability instance,EnumFacing side,NBTBase nbt) {
				NBTTagCompound root = (NBTTagCompound)nbt;
				instance.setHasShownHumantypeMenu(root.getBoolean("shownHumantypeMenu"));
			}
		},() -> new NewtypeCapability(null));
	}
	
	public static ICapabilityProvider createProvider(INewtypeCapability nc) {
		return new NewtypeProvider(MAX_NEWTYPE_CAPABILITY,DEFAULT_FACING,nc);
	}
	
	@Mod.EventBusSubscriber
	public static class EventHandler {
		@SubscribeEvent
		public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if(event.getObject() instanceof EntityPlayer) {
				final NewtypeCapability nc = new NewtypeCapability((EntityPlayer)event.getObject());
				event.addCapability(ID,createProvider(nc));
			}
		}
		
		@SubscribeEvent
		public static void hasConnected(PlayerEvent.PlayerLoggedInEvent event) {
			INewtypeCapability nt = CapabilityUtils.getCapability(event.player,MAX_NEWTYPE_CAPABILITY,DEFAULT_FACING);
			if(!nt.hasShownHumantypeMenu()) {
				event.player.showGui(GundamMod.instance,HumantypeGUI.GUI_ID,event.player.getEntityWorld(),event.player.getPosition().getX(),event.player.getPosition().getY(),event.player.getPosition().getZ());
			}
		}
	}
}
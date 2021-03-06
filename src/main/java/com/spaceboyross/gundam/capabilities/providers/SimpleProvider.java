package com.spaceboyross.gundam.capabilities.providers;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SimpleProvider<HANDLER> implements ICapabilitySerializable<NBTBase> {
	
	private Capability<HANDLER> capability;
	private EnumFacing facing;
	private HANDLER instance;
	
	public SimpleProvider(Capability<HANDLER> capability,@Nullable EnumFacing facing) {
		this(capability,facing,capability.getDefaultInstance());
	}
	
	public SimpleProvider(Capability<HANDLER> capability,@Nullable EnumFacing facing,HANDLER instance) {
		this.capability = capability;
		this.facing = facing;
		this.instance = instance;
	}

	@Override
	public boolean hasCapability(Capability<?> capability,EnumFacing facing) {
		return this.capability == this.getCapability();
	}

	@Override
	public <T> T getCapability(Capability<T> capability,EnumFacing facing) {
		if(this.capability == this.getCapability()) return this.getCapability().cast(this.getInstance());
		return null;
	}

	@Override
	public NBTBase serializeNBT() {
		return this.getCapability().writeNBT(this.getInstance(),this.getFacing());
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		this.getCapability().readNBT(this.getInstance(),this.getFacing(),nbt);
	}
	
	public final Capability<HANDLER> getCapability() {
		return this.capability;
	}
	
	@Nullable
	public EnumFacing getFacing() {
		return this.facing;
	}
	
	public final HANDLER getInstance() {
		return this.instance;
	}
}

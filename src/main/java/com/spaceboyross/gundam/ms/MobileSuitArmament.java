package com.spaceboyross.gundam.ms;

import net.minecraft.nbt.NBTTagCompound;

public abstract class MobileSuitArmament {

	private String name;
	private int count;
	
	public MobileSuitArmament(int count) {
		this.count = count;
	}
	
	public void onSwitch(MobileSuit.MSMob mob) {}
	
	public void onGrab(MobileSuit.MSMob mob) {}
	
	public void onUse(MobileSuit.MSMob mob) {}
	
	public NBTTagCompound saveNBT() {
		NBTTagCompound root = new NBTTagCompound();
		root.setString("name",this.getName());
		root.setInteger("count",this.getCount());
		return root;
	}
	
	public void loadNBT(NBTTagCompound root) {
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public String toString() {
		return this.getCount()+" × "+this.getName();
	}
}

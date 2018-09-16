package com.spaceboyross.gundam.capabilities.newtype;

import com.spaceboyross.gundam.capabilities.interfaces.INewtypeCapability;
import com.spaceboyross.gundam.enums.EHumantypes;
import com.spaceboyross.gundam.net.PacketHandler;
import com.spaceboyross.gundam.net.PacketNewtype;

import net.minecraft.entity.player.EntityPlayer;

public class NewtypeCapability implements INewtypeCapability {
	
	private boolean shownHumantypeMenu = false;
	private EHumantypes humantype = EHumantypes.OLDTYPE;
	
	private EntityPlayer player;
	
	public NewtypeCapability(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public EntityPlayer getPlayer() {
		return this.player;
	}

	@Override
	public boolean hasShownHumantypeMenu() {
		return this.shownHumantypeMenu;
	}

	@Override
	public void setHasShownHumantypeMenu(boolean v) {
		this.shownHumantypeMenu = v;
	}

	@Override
	public EHumantypes getHumantype() {
		return this.humantype;
	}

	@Override
	public void setHumantype(EHumantypes v) {
		this.humantype = v;
	}
	
	@Override
	public void syncToServer() {
		PacketHandler.INSTANCE.sendToServer(new PacketNewtype(this));
	}
}
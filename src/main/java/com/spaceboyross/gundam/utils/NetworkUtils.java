package com.spaceboyross.gundam.utils;

import com.spaceboyross.gundam.net.PacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class NetworkUtils {
	public static void sendToClient(IMessage message,EntityPlayer player) {
		PacketHandler.INSTANCE.sendTo(message,(EntityPlayerMP)player);
	}
	
	public static void sendToClients(IMessage message,EntityPlayer...players) {
		for(int i = 0;i < players.length;i++) NetworkUtils.sendToClient(message,players[i]);
	}
}
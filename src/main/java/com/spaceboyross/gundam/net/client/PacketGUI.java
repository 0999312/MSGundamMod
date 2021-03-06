package com.spaceboyross.gundam.net.client;

import java.util.UUID;

import com.spaceboyross.gundam.gui.HumantypeGUI;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketGUI implements IMessage {
	
	private int ID;
	
	public PacketGUI(int ID) {
		this.ID = ID;
	}
	
	public PacketGUI() {
		this.ID = 0;
	}
	
	@Override
    public void fromBytes(ByteBuf buf) {
		this.ID = buf.readInt();
	}

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeInt(this.ID);
    }
    
    public static class Handler implements IMessageHandler<PacketGUI,IMessage> {
        @Override
        public IMessage onMessage(PacketGUI message,MessageContext ctx) {
        	Minecraft.getMinecraft().addScheduledTask(() -> handle(message,ctx));
        	return null;
        }
        
        private void handle(PacketGUI message,MessageContext ctx) {
        	switch(message.ID) {
	        	case 0: Minecraft.getMinecraft().displayGuiScreen(new HumantypeGUI(Minecraft.getMinecraft().player));
	        		break;
        	}
        }
    }
}

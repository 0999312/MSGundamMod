package com.spaceboyross.gundam.net;

import com.spaceboyross.gundam.capabilities.interfaces.INewtypeCapability;
import com.spaceboyross.gundam.capabilities.newtype.Newtype;
import com.spaceboyross.gundam.enums.EHumantypes;
import com.spaceboyross.gundam.ms.MSRegistry;
import com.spaceboyross.gundam.ms.MobileSuit;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketNewtype implements IMessage {
	
	private boolean shownHumantypeMenu = false;
	private int humantype = 0;
	
	public PacketNewtype() {}
	
	public PacketNewtype(INewtypeCapability nt) {
		this.shownHumantypeMenu = nt.hasShownHumantypeMenu();
		this.humantype = nt.getHumantype().ordinal();
	}

    @Override
    public void fromBytes(ByteBuf buf) {
    	this.shownHumantypeMenu = buf.readBoolean();
    	this.humantype = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
    	buf.writeBoolean(this.shownHumantypeMenu);
    	buf.writeInt(this.humantype);
    }

    public static class Handler implements IMessageHandler<PacketNewtype,IMessage> {
        @Override
        public IMessage onMessage(PacketNewtype message,MessageContext ctx) {
            ctx.getServerHandler().player.getServerWorld().addScheduledTask(() -> handle(message,ctx));
            return null;
        }

        private void handle(PacketNewtype message,MessageContext ctx) {
            EntityPlayerMP playerEntity = ctx.getServerHandler().player;
            World world = playerEntity.getEntityWorld();
            INewtypeCapability nt = Newtype.getNewtype(playerEntity);
            nt.setHasShownHumantypeMenu(message.shownHumantypeMenu);
            nt.setHumantype(EHumantypes.values()[message.humantype]);
        }
    }
}

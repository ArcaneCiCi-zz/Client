package net.minecraft.client.network.packet.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet20NamedEntitySpawn extends Packet {

    public int entityId;
    public String name;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte rotation;
    public byte pitch;
    public int currentItem;
    public Packet20NamedEntitySpawn() {
    }
    public Packet20NamedEntitySpawn(EntityPlayer entityplayer) {
        entityId = entityplayer.entityID;
        name = entityplayer.username;
        xPosition = MathHelper.floor_double(entityplayer.posX * 32D);
        yPosition = MathHelper.floor_double(entityplayer.posY * 32D);
        zPosition = MathHelper.floor_double(entityplayer.posZ * 32D);
        rotation = (byte) (int) ((entityplayer.rotationYaw * 256F) / 360F);
        pitch = (byte) (int) ((entityplayer.rotationPitch * 256F) / 360F);
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        currentItem = itemstack != null ? itemstack.itemID : 0;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        entityId = datainputstream.readInt();
        name = datainputstream.readUTF();
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.readInt();
        zPosition = datainputstream.readInt();
        rotation = datainputstream.readByte();
        pitch = datainputstream.readByte();
        currentItem = datainputstream.readShort();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(entityId);
        dataoutputstream.writeUTF(name);
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.writeInt(yPosition);
        dataoutputstream.writeInt(zPosition);
        dataoutputstream.writeByte(rotation);
        dataoutputstream.writeByte(pitch);
        dataoutputstream.writeShort(currentItem);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleNamedEntitySpawn(this);
    }

    public int getPacketSize() {
        return 28;
    }
}

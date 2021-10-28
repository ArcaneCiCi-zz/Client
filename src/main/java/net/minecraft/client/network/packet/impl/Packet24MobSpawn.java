package net.minecraft.client.network.packet.impl;


import net.minecraft.client.entity.mob.impl.EntityList;
import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet24MobSpawn extends Packet {

    public int entityId;
    public byte type;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;
    public Packet24MobSpawn() {

    }
    public Packet24MobSpawn(EntityLiving entityliving) {
        entityId = entityliving.entityID;
        type = (byte) EntityList.getEntityID(entityliving);
        xPosition = MathHelper.floor_double(entityliving.posX * 32D);
        yPosition = MathHelper.floor_double(entityliving.posY * 32D);
        zPosition = MathHelper.floor_double(entityliving.posZ * 32D);
        yaw = (byte) (int) ((entityliving.rotationYaw * 256F) / 360F);
        pitch = (byte) (int) ((entityliving.rotationPitch * 256F) / 360F);
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        entityId = datainputstream.readInt();
        type = datainputstream.readByte();
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.readInt();
        zPosition = datainputstream.readInt();
        yaw = datainputstream.readByte();
        pitch = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(entityId);
        dataoutputstream.writeByte(type);
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.writeInt(yPosition);
        dataoutputstream.writeInt(zPosition);
        dataoutputstream.writeByte(yaw);
        dataoutputstream.writeByte(pitch);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleMobSpawn(this);
    }

    public int getPacketSize() {
        return 19;
    }
}

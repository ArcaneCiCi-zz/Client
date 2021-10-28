package net.minecraft.client.network.packet.impl;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet34EntityTeleport extends Packet {

    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;

    public Packet34EntityTeleport() {
    }
    public Packet34EntityTeleport(Entity entity) {
        entityId = entity.entityID;
        xPosition = MathHelper.floor_double(entity.posX * 32D);
        yPosition = MathHelper.floor_double(entity.posY * 32D);
        zPosition = MathHelper.floor_double(entity.posZ * 32D);
        yaw = (byte) (int) ((entity.rotationYaw * 256F) / 360F);
        pitch = (byte) (int) ((entity.rotationPitch * 256F) / 360F);
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        entityId = datainputstream.readInt();
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.readInt();
        zPosition = datainputstream.readInt();
        yaw = (byte) datainputstream.read();
        pitch = (byte) datainputstream.read();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(entityId);
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.writeInt(yPosition);
        dataoutputstream.writeInt(zPosition);
        dataoutputstream.write(yaw);
        dataoutputstream.write(pitch);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleEntityTeleport(this);
    }

    public int getPacketSize() {
        return 34;
    }
}

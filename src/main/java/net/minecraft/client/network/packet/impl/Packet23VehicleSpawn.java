package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet23VehicleSpawn extends Packet {

    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int type;

    public Packet23VehicleSpawn() {
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        entityId = datainputstream.readInt();
        type = datainputstream.readByte();
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.readInt();
        zPosition = datainputstream.readInt();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(entityId);
        dataoutputstream.writeByte(type);
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.writeInt(yPosition);
        dataoutputstream.writeInt(zPosition);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleVehicleSpawn(this);
    }

    public int getPacketSize() {
        return 17;
    }
}

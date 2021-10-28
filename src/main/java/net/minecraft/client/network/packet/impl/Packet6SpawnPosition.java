package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet6SpawnPosition extends Packet {

    public int xPosition;
    public int yPosition;
    public int zPosition;

    public Packet6SpawnPosition() {
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.readInt();
        zPosition = datainputstream.readInt();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.writeInt(yPosition);
        dataoutputstream.writeInt(zPosition);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleSpawnPosition(this);
    }

    public int getPacketSize() {
        return 12;
    }
}

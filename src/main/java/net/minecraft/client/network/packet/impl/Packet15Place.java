package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet15Place extends Packet {

    public int id;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int direction;

    public Packet15Place() {
    }

    public Packet15Place(int i, int j, int k, int l, int i1) {
        id = i;
        xPosition = j;
        yPosition = k;
        zPosition = l;
        direction = i1;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        id = datainputstream.readShort();
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.read();
        zPosition = datainputstream.readInt();
        direction = datainputstream.read();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeShort(id);
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.write(yPosition);
        dataoutputstream.writeInt(zPosition);
        dataoutputstream.write(direction);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handlePlace(this);
    }

    public int getPacketSize() {
        return 12;
    }
}

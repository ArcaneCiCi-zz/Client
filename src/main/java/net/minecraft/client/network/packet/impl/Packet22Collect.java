package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet22Collect extends Packet {

    public int collectedEntityId;
    public int collectorEntityId;

    public Packet22Collect() {
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        collectedEntityId = datainputstream.readInt();
        collectorEntityId = datainputstream.readInt();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(collectedEntityId);
        dataoutputstream.writeInt(collectorEntityId);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleCollect(this);
    }

    public int getPacketSize() {
        return 8;
    }
}

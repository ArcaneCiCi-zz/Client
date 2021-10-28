package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet4UpdateTime extends Packet {

    public long time;

    public Packet4UpdateTime() {
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        time = datainputstream.readLong();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeLong(time);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleUpdateTime(this);
    }

    public int getPacketSize() {
        return 8;
    }
}

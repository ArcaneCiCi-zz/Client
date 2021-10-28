package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet8 extends Packet {

    public int healthMP;

    public Packet8() {
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        healthMP = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeByte(healthMP);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleHealth(this);
    }

    public int getPacketSize() {
        return 1;
    }
}

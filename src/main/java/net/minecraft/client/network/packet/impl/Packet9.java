package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet9 extends Packet {

    public Packet9() {
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.func_9448_a(this);
    }

    public void readPacketData(DataInputStream datainputstream) {
    }

    public void writePacketData(DataOutputStream dataoutputstream) {
    }

    public int getPacketSize() {
        return 0;
    }
}

package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet38 extends Packet {

    public int field_9274_a;
    public byte field_9273_b;

    public Packet38() {
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        field_9274_a = datainputstream.readInt();
        field_9273_b = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(field_9274_a);
        dataoutputstream.writeByte(field_9273_b);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.func_9447_a(this);
    }

    public int getPacketSize() {
        return 5;
    }
}

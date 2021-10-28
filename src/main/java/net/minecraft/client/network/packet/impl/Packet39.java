package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet39 extends Packet {

    public int field_6365_a;
    public int field_6364_b;

    public Packet39() {
    }

    public int getPacketSize() {
        return 8;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        field_6365_a = datainputstream.readInt();
        field_6364_b = datainputstream.readInt();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(field_6365_a);
        dataoutputstream.writeInt(field_6364_b);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.func_6497_a(this);
    }
}

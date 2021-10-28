package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet7 extends Packet {

    public int field_9277_a;
    public int field_9276_b;
    public int field_9278_c;

    public Packet7() {
    }

    public Packet7(int i, int j, int k) {
        field_9277_a = i;
        field_9276_b = j;
        field_9278_c = k;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        field_9277_a = datainputstream.readInt();
        field_9276_b = datainputstream.readInt();
        field_9278_c = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(field_9277_a);
        dataoutputstream.writeInt(field_9276_b);
        dataoutputstream.writeByte(field_9278_c);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.func_6499_a(this);
    }

    public int getPacketSize() {
        return 9;
    }
}

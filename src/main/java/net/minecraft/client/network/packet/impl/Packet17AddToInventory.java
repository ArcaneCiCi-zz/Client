package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet17AddToInventory extends Packet {

    public int id;
    public int count;
    public int durability;

    public Packet17AddToInventory() {
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        id = datainputstream.readShort();
        count = datainputstream.readByte();
        durability = datainputstream.readShort();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeShort(id);
        dataoutputstream.writeByte(count);
        dataoutputstream.writeShort(durability);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleAddToInventory(this);
    }

    public int getPacketSize() {
        return 5;
    }
}

package net.minecraft.client.network.packet.impl;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet28 extends Packet {

    public int field_6367_a;
    public int field_6366_b;
    public int field_6369_c;
    public int field_6368_d;

    public Packet28() {

    }

    public Packet28(Entity entity) {
        this(entity.entityID, entity.motionX, entity.motionY, entity.motionZ);
    }

    public Packet28(int i, double d, double d1, double d2) {
        field_6367_a = i;
        double d3 = 3.8999999999999999D;
        if (d < -d3) {
            d = -d3;
        }
        if (d1 < -d3) {
            d1 = -d3;
        }
        if (d2 < -d3) {
            d2 = -d3;
        }
        if (d > d3) {
            d = d3;
        }
        if (d1 > d3) {
            d1 = d3;
        }
        if (d2 > d3) {
            d2 = d3;
        }
        field_6366_b = (int) (d * 8000D);
        field_6369_c = (int) (d1 * 8000D);
        field_6368_d = (int) (d2 * 8000D);
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        field_6367_a = datainputstream.readInt();
        field_6366_b = datainputstream.readShort();
        field_6369_c = datainputstream.readShort();
        field_6368_d = datainputstream.readShort();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(field_6367_a);
        dataoutputstream.writeShort(field_6366_b);
        dataoutputstream.writeShort(field_6369_c);
        dataoutputstream.writeShort(field_6368_d);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.func_6498_a(this);
    }

    public int getPacketSize() {
        return 10;
    }
}

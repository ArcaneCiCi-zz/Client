package net.minecraft.client.network.packet.impl;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet32EntityLook extends Packet30Entity {

    public Packet32EntityLook() {
        rotating = true;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        super.readPacketData(datainputstream);
        yaw = datainputstream.readByte();
        pitch = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        super.writePacketData(dataoutputstream);
        dataoutputstream.writeByte(yaw);
        dataoutputstream.writeByte(pitch);
    }

    public int getPacketSize() {
        return 6;
    }
}

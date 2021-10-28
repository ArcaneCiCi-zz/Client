package net.minecraft.client.network.packet.impl;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet33RelEntityMoveLook extends Packet30Entity {

    public Packet33RelEntityMoveLook() {
        rotating = true;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        super.readPacketData(datainputstream);
        xPosition = datainputstream.readByte();
        yPosition = datainputstream.readByte();
        zPosition = datainputstream.readByte();
        yaw = datainputstream.readByte();
        pitch = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        super.writePacketData(dataoutputstream);
        dataoutputstream.writeByte(xPosition);
        dataoutputstream.writeByte(yPosition);
        dataoutputstream.writeByte(zPosition);
        dataoutputstream.writeByte(yaw);
        dataoutputstream.writeByte(pitch);
    }

    public int getPacketSize() {
        return 9;
    }
}

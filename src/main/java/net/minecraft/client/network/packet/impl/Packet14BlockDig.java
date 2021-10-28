package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet14BlockDig extends Packet {

    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int face;
    public int status;

    public Packet14BlockDig() {
    }

    public Packet14BlockDig(int i, int j, int k, int l, int i1) {
        status = i;
        xPosition = j;
        yPosition = k;
        zPosition = l;
        face = i1;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        status = datainputstream.read();
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.read();
        zPosition = datainputstream.readInt();
        face = datainputstream.read();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
//        System.out.println("--- BROKEN ---");
//        System.out.println("status: " + status);
//        System.out.println("xPos: " + xPosition);
//        System.out.println("yPos: " + yPosition);
//        System.out.println("zPos: " + zPosition);
//        System.out.println("face: " + face);
//        System.out.println("--- BROKEN ---");

        dataoutputstream.write(status);
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.write(yPosition);
        dataoutputstream.writeInt(zPosition);
        dataoutputstream.write(face);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleBlockDig(this);
    }

    public int getPacketSize() {
        return 11;
    }
}

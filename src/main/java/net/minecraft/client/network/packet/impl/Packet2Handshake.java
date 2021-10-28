package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet2Handshake extends Packet {

    public String username;

    public Packet2Handshake() {
    }

    public Packet2Handshake(String s) {
        username = s;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        username = datainputstream.readUTF();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeUTF(username);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleHandshake(this);
    }

    public int getPacketSize() {
        return 4 + username.length() + 4;
    }
}

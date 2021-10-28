package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet1Login extends Packet {

    public int protocolVersion;
    public String username;
    public String password;
    public long field_4074_d;
    public byte field_4073_e;

    public Packet1Login() {

    }

    public Packet1Login(String s, String s1, int i) {
        username = s;
        password = s1;
        protocolVersion = i;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        protocolVersion = datainputstream.readInt();
        username = datainputstream.readUTF();
        password = datainputstream.readUTF();
        field_4074_d = datainputstream.readLong();
        field_4073_e = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(protocolVersion);
        dataoutputstream.writeUTF(username);
        dataoutputstream.writeUTF(password);
        dataoutputstream.writeLong(field_4074_d);
        dataoutputstream.writeByte(field_4073_e);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleLogin(this);
    }

    public int getPacketSize() {
        return 4 + username.length() + password.length() + 4 + 5;
    }
}

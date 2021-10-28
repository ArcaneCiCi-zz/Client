package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet10Flying extends Packet {

    public double xPosition;
    public double yPosition;
    public double zPosition;
    public double stance;
    public float yaw;
    public float pitch;
    public boolean onGround;
    public boolean moving;
    public boolean rotating;

    public Packet10Flying() {

    }

    public Packet10Flying(boolean flag) {
        onGround = flag;
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleFlying(this);
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        onGround = true;
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.write(onGround ? 1 : 0);
    }

    public int getPacketSize() {
        return 1;
    }
}

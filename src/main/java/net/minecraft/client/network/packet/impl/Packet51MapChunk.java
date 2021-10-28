package net.minecraft.client.network.packet.impl;


import net.minecraft.client.network.manager.NetHandler;
import net.minecraft.client.network.packet.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Packet51MapChunk extends Packet {

    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int xSize;
    public int ySize;
    public int zSize;
    public byte[] chunk;
    private int chunkSize;
    public Packet51MapChunk() {
        isChunkDataPacket = true;
    }

    public void readPacketData(DataInputStream datainputstream) throws IOException {
        xPosition = datainputstream.readInt();
        yPosition = datainputstream.readShort();
        zPosition = datainputstream.readInt();
        xSize = datainputstream.read() + 1;
        ySize = datainputstream.read() + 1;
        zSize = datainputstream.read() + 1;
        int i = datainputstream.readInt();
        byte[] abyte0 = new byte[i];
        datainputstream.readFully(abyte0);
        chunk = new byte[(xSize * ySize * zSize * 5) / 2];
        Inflater inflater = new Inflater();
        inflater.setInput(abyte0);
        try {
            inflater.inflate(chunk);
        } catch (DataFormatException dataformatexception) {
            throw new IOException("Bad compressed data format");
        } finally {
            inflater.end();
        }
    }

    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(xPosition);
        dataoutputstream.writeShort(yPosition);
        dataoutputstream.writeInt(zPosition);
        dataoutputstream.write(xSize - 1);
        dataoutputstream.write(ySize - 1);
        dataoutputstream.write(zSize - 1);
        dataoutputstream.writeInt(chunkSize);
        dataoutputstream.write(chunk, 0, chunkSize);
    }

    public void processPacket(NetHandler nethandler) {
        nethandler.handleMapChunk(this);
    }

    public int getPacketSize() {
        return 17 + chunkSize;
    }
}

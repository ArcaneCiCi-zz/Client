package net.minecraft.client.nbt;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByte extends NBTBase {

    public byte byteValue;

    public NBTTagByte() {
    }

    public NBTTagByte(byte byte0) {
        byteValue = byte0;
    }

    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeByte(byteValue);
    }

    void readTagContents(DataInput datainput) throws IOException {
        byteValue = datainput.readByte();
    }

    public byte getType() {
        return 1;
    }

    public String toString() {
        return (new StringBuilder()).append(byteValue).toString();
    }
}

package net.minecraft.client.nbt;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagShort extends NBTBase {

    public short shortValue;

    public NBTTagShort() {
    }

    public NBTTagShort(short word0) {
        shortValue = word0;
    }

    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeShort(shortValue);
    }

    void readTagContents(DataInput datainput) throws IOException {
        shortValue = datainput.readShort();
    }

    public byte getType() {
        return 2;
    }

    public String toString() {
        return (new StringBuilder()).append(shortValue).toString();
    }
}

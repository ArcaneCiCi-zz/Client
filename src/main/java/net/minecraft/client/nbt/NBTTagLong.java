package net.minecraft.client.nbt;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagLong extends NBTBase {

    public long longValue;

    public NBTTagLong() {
    }

    public NBTTagLong(long l) {
        longValue = l;
    }

    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeLong(longValue);
    }

    void readTagContents(DataInput datainput) throws IOException {
        longValue = datainput.readLong();
    }

    public byte getType() {
        return 4;
    }

    public String toString() {
        return (new StringBuilder()).append(longValue).toString();
    }
}

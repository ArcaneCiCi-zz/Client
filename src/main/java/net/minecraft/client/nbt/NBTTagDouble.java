package net.minecraft.client.nbt;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagDouble extends NBTBase {

    public double doubleValue;

    public NBTTagDouble() {
    }

    public NBTTagDouble(double d) {
        doubleValue = d;
    }

    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeDouble(doubleValue);
    }

    void readTagContents(DataInput datainput) throws IOException {
        doubleValue = datainput.readDouble();
    }

    public byte getType() {
        return 6;
    }

    public String toString() {
        return (new StringBuilder()).append(doubleValue).toString();
    }
}

package net.minecraft.client.nbt;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagString extends NBTBase {

    public String stringValue;

    public NBTTagString() {
    }

    public NBTTagString(String s) {
        stringValue = s;
        if (s == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        } else {
            return;
        }
    }

    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeUTF(stringValue);
    }

    void readTagContents(DataInput datainput) throws IOException {
        stringValue = datainput.readUTF();
    }

    public byte getType() {
        return 8;
    }

    public String toString() {
        return (new StringBuilder()).append(stringValue).toString();
    }
}

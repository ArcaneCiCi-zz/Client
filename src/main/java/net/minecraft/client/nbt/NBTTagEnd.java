package net.minecraft.client.nbt;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagEnd extends NBTBase {

    public NBTTagEnd() {
    }

    void readTagContents(DataInput datainput) throws IOException {
    }

    void writeTagContents(DataOutput dataoutput) throws IOException {
    }

    public byte getType() {
        return 0;
    }

    public String toString() {
        return "END";
    }
}

package net.minecraft.client.nbt;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NBTTagList extends NBTBase {

    private List tagList;
    private byte tagType;

    public NBTTagList() {
        tagList = new ArrayList<>();
    }

    void writeTagContents(DataOutput dataoutput) throws IOException {
        if (tagList.size() > 0) {
            tagType = ((NBTBase) tagList.get(0)).getType();
        } else {
            tagType = 1;
        }
        dataoutput.writeByte(tagType);
        dataoutput.writeInt(tagList.size());
        for (int i = 0; i < tagList.size(); i++) {
            ((NBTBase) tagList.get(i)).writeTagContents(dataoutput);
        }

    }

    void readTagContents(DataInput datainput) throws IOException {
        tagType = datainput.readByte();
        int i = datainput.readInt();
        tagList = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            NBTBase nbtbase = createTagOfType(tagType);
            nbtbase.readTagContents(datainput);
            tagList.add(nbtbase);
        }

    }

    public byte getType() {
        return 9;
    }

    public String toString() {
        return (new StringBuilder()).append(tagList.size()).append(" entries of type ").append(getTagName(tagType)).toString();
    }

    public void setTag(NBTBase nbtbase) {
        tagType = nbtbase.getType();
        tagList.add(nbtbase);
    }

    public NBTBase tagAt(int i) {
        return (NBTBase) tagList.get(i);
    }

    public int tagCount() {
        return tagList.size();
    }
}

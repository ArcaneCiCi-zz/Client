package net.minecraft.client.world.tile;


import net.minecraft.client.nbt.NBTTagCompound;

public class TileEntitySign extends TileEntity {

    public String[] signText = {
            "", "", "", ""
    };
    public int lineBeingEdited;

    public TileEntitySign() {
        lineBeingEdited = -1;
    }

    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setString("Text1", signText[0]);
        nbttagcompound.setString("Text2", signText[1]);
        nbttagcompound.setString("Text3", signText[2]);
        nbttagcompound.setString("Text4", signText[3]);
    }

    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        for (int i = 0; i < 4; i++) {
            signText[i] = nbttagcompound.getString((new StringBuilder()).append("Text").append(i + 1).toString());
            if (signText[i].length() > 15) {
                signText[i] = signText[i].substring(0, 15);
            }
        }

    }
}

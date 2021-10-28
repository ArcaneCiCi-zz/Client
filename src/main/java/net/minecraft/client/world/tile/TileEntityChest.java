package net.minecraft.client.world.tile;


import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.nbt.NBTTagCompound;
import net.minecraft.client.nbt.NBTTagList;

public class TileEntityChest extends TileEntity implements IInventory {

    private ItemStack[] field_827_a;

    public TileEntityChest() {
        field_827_a = new ItemStack[36];
    }

    public int getSizeInventory() {
        return 27;
    }

    public ItemStack getStackInSlot(int i) {
        return field_827_a[i];
    }

    public ItemStack decrStackSize(int i, int j) {
        if (field_827_a[i] != null) {
            if (field_827_a[i].stackSize <= j) {
                ItemStack itemstack = field_827_a[i];
                field_827_a[i] = null;
                onInventoryChanged();
                return itemstack;
            }
            ItemStack itemstack1 = field_827_a[i].splitStack(j);
            if (field_827_a[i].stackSize == 0) {
                field_827_a[i] = null;
            }
            onInventoryChanged();
            return itemstack1;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack) {
        field_827_a[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
            itemstack.stackSize = getInventoryStackLimit();
        }
        onInventoryChanged();
    }

    public String getInvName() {
        return "Chest";
    }

    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        field_827_a = new ItemStack[getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); i++) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xff;
            if (j >= 0 && j < field_827_a.length) {
                field_827_a[j] = new ItemStack(nbttagcompound1);
            }
        }

    }

    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < field_827_a.length; i++) {
            if (field_827_a[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                field_827_a[i].writeToNBT(nbttagcompound1);
                nbttaglist.setTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit() {
        return 64;
    }
}

package net.minecraft.client.interfaces;


import net.minecraft.client.item.impl.ItemStack;

public interface IInventory {

    int getSizeInventory();

    ItemStack getStackInSlot(int i);

    ItemStack decrStackSize(int i, int j);

    void setInventorySlotContents(int i, ItemStack itemstack);

    String getInvName();

    int getInventoryStackLimit();

    void onInventoryChanged();
}

package net.minecraft.client.ui.inventory;


import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;

public class InventoryCraftResult implements IInventory {

    private final ItemStack[] stackResult;

    public InventoryCraftResult() {
        stackResult = new ItemStack[1];
    }

    public int getSizeInventory() {
        return 1;
    }

    public ItemStack getStackInSlot(int i) {
        return stackResult[i];
    }

    public String getInvName() {
        return "Result";
    }

    public ItemStack decrStackSize(int i, int j) {
        if (stackResult[i] != null) {
            ItemStack itemstack = stackResult[i];
            stackResult[i] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack) {
        stackResult[i] = itemstack;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void onInventoryChanged() {
    }
}

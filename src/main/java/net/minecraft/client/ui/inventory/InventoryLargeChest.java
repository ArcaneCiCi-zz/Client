package net.minecraft.client.ui.inventory;


import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;

public class InventoryLargeChest
        implements IInventory {

    private final String name;
    private final IInventory upperChest;
    private final IInventory lowerChest;

    public InventoryLargeChest(String s, IInventory iinventory, IInventory iinventory1) {
        name = s;
        upperChest = iinventory;
        lowerChest = iinventory1;
    }

    public int getSizeInventory() {
        return upperChest.getSizeInventory() + lowerChest.getSizeInventory();
    }

    public String getInvName() {
        return name;
    }

    public ItemStack getStackInSlot(int i) {
        if (i >= upperChest.getSizeInventory()) {
            return lowerChest.getStackInSlot(i - upperChest.getSizeInventory());
        } else {
            return upperChest.getStackInSlot(i);
        }
    }

    public ItemStack decrStackSize(int i, int j) {
        if (i >= upperChest.getSizeInventory()) {
            return lowerChest.decrStackSize(i - upperChest.getSizeInventory(), j);
        } else {
            return upperChest.decrStackSize(i, j);
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack) {
        if (i >= upperChest.getSizeInventory()) {
            lowerChest.setInventorySlotContents(i - upperChest.getSizeInventory(), itemstack);
        } else {
            upperChest.setInventorySlotContents(i, itemstack);
        }
    }

    public int getInventoryStackLimit() {
        return upperChest.getInventoryStackLimit();
    }

    public void onInventoryChanged() {
        upperChest.onInventoryChanged();
        lowerChest.onInventoryChanged();
    }
}

package net.minecraft.client.ui.inventory.slot;


import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;

public class Slot {

    public final int slotIndex;
    public final IInventory inventory;

    public Slot(IInventory iinventory, int i) {
        inventory = iinventory;
        slotIndex = i;
    }

    public void onPickupFromSlot() {
        onSlotChanged();
    }

    public boolean isItemValid(ItemStack itemstack) {
        return true;
    }

    public ItemStack getStack() {
        return inventory.getStackInSlot(slotIndex);
    }

    public void putStack(ItemStack itemstack) {
        inventory.setInventorySlotContents(slotIndex, itemstack);
        onSlotChanged();
    }

    public int func_775_c() {
        return -1;
    }

    public void onSlotChanged() {
        inventory.onInventoryChanged();
    }

    public int getSlotStackLimit() {
        return inventory.getInventoryStackLimit();
    }
}

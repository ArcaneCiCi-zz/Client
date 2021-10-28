package net.minecraft.client.ui.inventory.slot.impl;

import net.minecraft.client.gui.container.GuiContainer;
import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;

public class SlotCrafting extends SlotInventory {

    private final IInventory craftMatrix;

    public SlotCrafting(GuiContainer guicontainer, IInventory iinventory, IInventory iinventory1, int i, int j, int k) {
        super(guicontainer, iinventory1, i, j, k);
        craftMatrix = iinventory;
    }

    public boolean isItemValid(ItemStack itemstack) {
        return false;
    }

    public void onPickupFromSlot() {
        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (craftMatrix.getStackInSlot(i) != null) {
                craftMatrix.decrStackSize(i, 1);
            }
        }

    }
}

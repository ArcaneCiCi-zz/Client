package net.minecraft.client.ui.crafting.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.ui.crafting.CraftingManager;
import net.minecraft.client.ui.inventory.InventoryCraftResult;
import net.minecraft.client.ui.inventory.InventoryCrafting;

public class CraftingInventoryWorkbenchCB extends CraftingInventoryCB {

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;

    public CraftingInventoryWorkbenchCB() {
        craftMatrix = new InventoryCrafting(this, 3, 3);
        craftResult = new InventoryCraftResult();
    }

    public void onCraftMatrixChanged(IInventory iinventory) {
        int[] ai = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int k = i + j * 3;
                ItemStack itemstack = craftMatrix.getStackInSlot(k);
                if (itemstack == null) {
                    ai[k] = -1;
                } else {
                    ai[k] = itemstack.itemID;
                }
            }

        }

        craftResult.setInventorySlotContents(0, CraftingManager.getInstance().craft(ai));
    }

    public void onCraftGuiClosed(EntityPlayer entityplayer) {
        super.onCraftGuiClosed(entityplayer);
        for (int i = 0; i < 9; i++) {
            ItemStack itemstack = craftMatrix.getStackInSlot(i);
            if (itemstack != null) {
                entityplayer.dropPlayerItem(itemstack);
            }
        }

    }
}

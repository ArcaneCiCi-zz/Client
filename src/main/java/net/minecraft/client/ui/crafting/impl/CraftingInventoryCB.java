package net.minecraft.client.ui.crafting.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.ui.inventory.InventoryPlayer;

import java.util.ArrayList;
import java.util.List;

public class CraftingInventoryCB {

    protected List unusedList;

    public CraftingInventoryCB() {
        unusedList = new ArrayList<>();
    }

    public void onCraftGuiClosed(EntityPlayer entityplayer) {
        InventoryPlayer inventoryplayer = entityplayer.inventory;
        if (inventoryplayer.draggingItemStack != null) {
            entityplayer.dropPlayerItem(inventoryplayer.draggingItemStack);
        }
    }

    public void onCraftMatrixChanged(IInventory iinventory) {
    }

    public boolean func_20120_b(EntityPlayer entityplayer) {
        return entityplayer != null;
    }
}

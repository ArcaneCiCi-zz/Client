package net.minecraft.client.ui.inventory.slot.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.gui.container.GuiContainer;
import net.minecraft.client.gui.impl.GuiInventory;
import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemArmor;
import net.minecraft.client.item.impl.ItemStack;

public class SlotArmor extends SlotInventory {

    final int field_1124_c;
    final GuiInventory field_1123_d;

    public SlotArmor(GuiInventory guiinventory, GuiContainer guicontainer, IInventory iinventory, int i, int j, int k, int l) {
        super(guicontainer, iinventory, i, j, k);
        field_1123_d = guiinventory;
        field_1124_c = l;
    }

    public int getSlotStackLimit() {
        return 1;
    }

    public boolean isItemValid(ItemStack itemstack) {
        if (itemstack.getItem() instanceof ItemArmor) {
            return ((ItemArmor) itemstack.getItem()).armorType == field_1124_c;
        }
        System.out.println((new StringBuilder()).append(itemstack.getItem().shiftedIndex).append(", ").append(field_1124_c));
        if (itemstack.getItem().shiftedIndex == Block.pumpkin.blockID) {
            return field_1124_c == 0;
        } else {
            return false;
        }
    }

    public int func_775_c() {
        return 15 + field_1124_c * 16;
    }
}

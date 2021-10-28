package net.minecraft.client.ui.inventory.slot.impl;


import net.minecraft.client.gui.container.GuiContainer;
import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.ui.inventory.slot.Slot;

public class SlotInventory extends Slot {

    public final int xPos;
    public final int yPos;
    private final GuiContainer guiHandler;
    public SlotInventory(GuiContainer guicontainer, IInventory iinventory, int i, int j, int k) {
        super(iinventory, i);
        guiHandler = guicontainer;
        xPos = j;
        yPos = k;
    }

    public boolean isAtCursorPos(int i, int j) {
        int k = (guiHandler.width - guiHandler.xSize) / 2;
        int l = (guiHandler.height - guiHandler.ySize) / 2;
        i -= k;
        j -= l;
        return i >= xPos - 1 && i < xPos + 16 + 1 && j >= yPos - 1 && j < yPos + 16 + 1;
    }
}

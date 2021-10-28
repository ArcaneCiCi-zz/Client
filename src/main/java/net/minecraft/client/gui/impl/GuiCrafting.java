package net.minecraft.client.gui.impl;


import net.minecraft.client.gui.container.GuiContainer;
import net.minecraft.client.ui.crafting.impl.CraftingInventoryWorkbenchCB;
import net.minecraft.client.ui.inventory.InventoryPlayer;
import net.minecraft.client.ui.inventory.slot.impl.SlotCrafting;
import net.minecraft.client.ui.inventory.slot.impl.SlotInventory;
import org.lwjgl.opengl.GL11;

public class GuiCrafting extends GuiContainer {

    public CraftingInventoryWorkbenchCB field_979_j;

    public GuiCrafting(InventoryPlayer inventoryplayer) {
        field_979_j = new CraftingInventoryWorkbenchCB();
        inventorySlots.add(new SlotCrafting(this, field_979_j.craftMatrix, field_979_j.craftResult, 0, 124, 35));
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 3; l++) {
                inventorySlots.add(new SlotInventory(this, field_979_j.craftMatrix, l + i * 3, 30 + l * 18, 17 + i * 18));
            }

        }

        for (int j = 0; j < 3; j++) {
            for (int i1 = 0; i1 < 9; i1++) {
                inventorySlots.add(new SlotInventory(this, inventoryplayer, i1 + (j + 1) * 9, 8 + i1 * 18, 84 + j * 18));
            }

        }

        for (int k = 0; k < 9; k++) {
            inventorySlots.add(new SlotInventory(this, inventoryplayer, k, 8 + k * 18, 142));
        }

    }

    public void onGuiClosed() {
        super.onGuiClosed();
        field_979_j.onCraftGuiClosed(mc.thePlayer);
    }

    protected void drawGuiContainerForegroundLayer() {
        fontRenderer.drawString("Crafting", 28, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f) {
        int i = mc.renderEngine.getTexture("/gui/crafting.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
    }
}

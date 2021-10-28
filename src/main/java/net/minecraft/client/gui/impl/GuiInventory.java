package net.minecraft.client.gui.impl;


import net.minecraft.client.entity.mob.render.RenderManager;
import net.minecraft.client.entity.render.RenderHelper;
import net.minecraft.client.gui.container.GuiContainer;
import net.minecraft.client.interfaces.IInventory;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.ui.crafting.impl.CraftingInventoryPlayerCB;
import net.minecraft.client.ui.inventory.slot.impl.SlotArmor;
import net.minecraft.client.ui.inventory.slot.impl.SlotCrafting;
import net.minecraft.client.ui.inventory.slot.impl.SlotInventory;
import org.lwjgl.opengl.GL11;

public class GuiInventory extends GuiContainer {

    private final CraftingInventoryPlayerCB field_977_j;
    private float xSize_lo;
    private float ySize_lo;

    public GuiInventory(IInventory iinventory, ItemStack[] aitemstack) {
        field_948_f = true;
        field_977_j = new CraftingInventoryPlayerCB(aitemstack);
        inventorySlots.add(new SlotCrafting(this, field_977_j.craftMatrix, field_977_j.craftResult, 0, 144, 36));
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 2; i1++) {
                inventorySlots.add(new SlotInventory(this, field_977_j.craftMatrix, i1 + i * 2, 88 + i1 * 18, 26 + i * 18));
            }

        }

        for (int j = 0; j < 4; j++) {
            int j1 = j;
            inventorySlots.add(new SlotArmor(this, this, iinventory, iinventory.getSizeInventory() - 1 - j, 8, 8 + j * 18, j1));
        }

        for (int k = 0; k < 3; k++) {
            for (int k1 = 0; k1 < 9; k1++) {
                inventorySlots.add(new SlotInventory(this, iinventory, k1 + (k + 1) * 9, 8 + k1 * 18, 84 + k * 18));
            }

        }

        for (int l = 0; l < 9; l++) {
            inventorySlots.add(new SlotInventory(this, iinventory, l, 8 + l * 18, 142));
        }

    }

    protected void drawGuiContainerForegroundLayer() {
        fontRenderer.drawString("Crafting", 86, 16, 0x404040);
    }

    public void drawScreen(int i, int j, float f) {
        super.drawScreen(i, j, f);
        xSize_lo = i;
        ySize_lo = j;
    }

    protected void drawGuiContainerBackgroundLayer(float f) {
        int i = mc.renderEngine.getTexture("/gui/inventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        GL11.glPushMatrix();
        GL11.glTranslatef(j + 51, k + 75, 50F);
        float f1 = 30F;
        GL11.glScalef(-f1, f1, f1);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        float f2 = mc.thePlayer.renderYawOffset;
        float f3 = mc.thePlayer.rotationYaw;
        float f4 = mc.thePlayer.rotationPitch;
        float f5 = (float) (j + 51) - xSize_lo;
        float f6 = (float) ((k + 75) - 50) - ySize_lo;
        GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(float) Math.atan(f6 / 40F) * 20F, 1.0F, 0.0F, 0.0F);
        mc.thePlayer.renderYawOffset = (float) Math.atan(f5 / 40F) * 20F;
        mc.thePlayer.rotationYaw = (float) Math.atan(f5 / 40F) * 40F;
        mc.thePlayer.rotationPitch = -(float) Math.atan(f6 / 40F) * 20F;
        GL11.glTranslatef(0.0F, mc.thePlayer.yOffset, 0.0F);
        RenderManager.instance.func_853_a(mc.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        mc.thePlayer.renderYawOffset = f2;
        mc.thePlayer.rotationYaw = f3;
        mc.thePlayer.rotationPitch = f4;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
    }
}

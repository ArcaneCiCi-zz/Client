package net.minecraft.client.gui.impl;


import me.arcanecici.client.util.ChatColor;
import org.lwjgl.opengl.GL11;

public class GuiGameOver extends GuiScreen {

    public GuiGameOver() {
    }

    public void initGui() {
        controlList.clear();
        controlList.add(new GuiButton(1, width / 2 - 100, height / 4 + 72, "Respawn"));
        controlList.add(new GuiButton(2, width / 2 - 100, height / 4 + 96, "Title menu"));
        if (mc.session == null) {
            ((GuiButton) controlList.get(1)).enabled = false;
        }
    }

    protected void keyTyped(char c, int i) {
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id != 0) ;
        if (guibutton.id == 1) {
            mc.thePlayer.func_9367_r();
            mc.displayGuiScreen(null);
        }
        if (guibutton.id == 2) {
            mc.func_6261_a(null);
            mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    public void drawScreen(int i, int j, float f) {
        drawGradientRect(0, 0, width, height, 0x60500000, 0xa0803030);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        drawCenteredString(fontRenderer, "Game over!", width / 2 / 2, 30, 0xffffff);
        GL11.glPopMatrix();
        drawCenteredString(fontRenderer, (new StringBuilder()).append(ChatColor.YELLOW + "Score: ").append(mc.thePlayer.getScore()).toString(), width / 2, 100, 0xffffff);
        super.drawScreen(i, j, f);
    }

    public boolean doesGuiPauseGame() {
        return false;
    }
}

package net.minecraft.client.gui.impl;


import net.minecraft.client.Minecraft;
import net.minecraft.client.world.World;

public class GuiDeleteWorld extends GuiSelectWorld {

    public GuiDeleteWorld(GuiScreen guiscreen) {
        super(guiscreen);
        screenTitle = "Delete world";
    }

    public void drawExtraButtons() {
        controlList.add(new GuiButton(6, width / 2 - 100, height / 6 + 168, "Cancel"));
    }

    public void selectWorld(int i) {
        if (getWorldName(i) != null) {
            mc.displayGuiScreen(new GuiYesNo(this, "Are you sure you want to delete this world?", "'" + getWorldName(i) + "' will be lost forever!", i));
        }
    }

    public void deleteWorld(boolean flag, int i) {
        if (flag) {
            java.io.File file = Minecraft.getMinecraftDir();
            World.deleteWorld(file, getWorldName(i));
        }
        mc.displayGuiScreen(parentScreen);
    }
}

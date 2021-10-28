package net.minecraft.client.gui.impl;


public class GuiYesNo extends GuiScreen {

    private final GuiScreen parentScreen;
    private final String message1;
    private final String message2;
    private final int worldNumber;

    public GuiYesNo(GuiScreen guiscreen, String s, String s1, int i) {
        parentScreen = guiscreen;
        message1 = s;
        message2 = s1;
        worldNumber = i;
    }

    public void initGui() {
        controlList.add(new GuiSmallButton(0, (width / 2 - 155) + 0, height / 6 + 96, "Yes"));
        controlList.add(new GuiSmallButton(1, (width / 2 - 155) + 160, height / 6 + 96, "No"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        parentScreen.deleteWorld(guibutton.id == 0, worldNumber);
    }

    public void drawScreen(int i, int j, float f) {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, message1, width / 2, 70, 0xffffff);
        drawCenteredString(fontRenderer, message2, width / 2, 90, 0xffffff);
        super.drawScreen(i, j, f);
    }
}

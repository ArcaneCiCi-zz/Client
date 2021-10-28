package net.minecraft.client.gui.impl;


public class GuiConnectFailed extends GuiScreen {

    private final String errorMessage;
    private final String errorDetail;

    public GuiConnectFailed(String s, String s1) {
        errorMessage = s;
        errorDetail = s1;
    }

    public void updateScreen() {
    }

    protected void keyTyped(char c, int i) {
    }

    public void initGui() {
        controlList.clear();
        controlList.add(new GuiButton(0, width / 2 - 100, height / 4 + 120 + 12, "Back to title screen"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    public void drawScreen(int i, int j, float f) {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, errorMessage, width / 2, height / 2 - 50, 0xffffff);
        drawCenteredString(fontRenderer, errorDetail, width / 2, height / 2 - 10, 0xffffff);
        super.drawScreen(i, j, f);
    }
}

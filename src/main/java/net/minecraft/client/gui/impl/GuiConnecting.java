package net.minecraft.client.gui.impl;


import net.minecraft.client.Minecraft;
import net.minecraft.client.network.manager.NetClientHandler;
import net.minecraft.client.thread.ThreadConnectToServer;

public class GuiConnecting extends GuiScreen {

    private NetClientHandler clientHandler;
    private boolean cancelled;

    public GuiConnecting(Minecraft minecraft, String s, int i) {
        cancelled = false;
        minecraft.func_6261_a(null);
        (new ThreadConnectToServer(this, minecraft, s, i)).start();
    }

    public static NetClientHandler setNetClientHandler(GuiConnecting guiconnecting, NetClientHandler netclienthandler) {
        return guiconnecting.clientHandler = netclienthandler;
    }

    public static boolean isCancelled(GuiConnecting guiconnecting) {
        return guiconnecting.cancelled;
    }

    public static NetClientHandler getNetClientHandler(GuiConnecting guiconnecting) {
        return guiconnecting.clientHandler;
    }

    public void updateScreen() {
        if (clientHandler != null) {
            clientHandler.processReadPackets();
        }
    }

    protected void keyTyped(char c, int i) {
    }

    public void initGui() {
        controlList.clear();
        controlList.add(new GuiButton(0, width / 2 - 100, height / 4 + 120 + 12, "Cancel"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            cancelled = true;
            if (clientHandler != null) {
                clientHandler.disconnect();
            }
            mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    public void drawScreen(int i, int j, float f) {
        drawDefaultBackground();
        if (clientHandler == null) {
            drawCenteredString(fontRenderer, "Connecting to the server...", width / 2, height / 2 - 50, 0xffffff);
            drawCenteredString(fontRenderer, "", width / 2, height / 2 - 10, 0xffffff);
        } else {
            drawCenteredString(fontRenderer, "Logging in...", width / 2, height / 2 - 50, 0xffffff);
            drawCenteredString(fontRenderer, clientHandler.field_1209_a, width / 2, height / 2 - 10, 0xffffff);
        }
        super.drawScreen(i, j, f);
    }
}

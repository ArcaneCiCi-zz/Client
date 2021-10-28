package net.minecraft.client.gui.impl;


import net.minecraft.client.network.manager.NetClientHandler;
import net.minecraft.client.network.packet.impl.Packet0KeepAlive;

public class GuiDownloadTerrain extends GuiScreen {

    private final NetClientHandler netHandler;
    private int updateCounter;

    public GuiDownloadTerrain(NetClientHandler netclienthandler) {
        updateCounter = 0;
        netHandler = netclienthandler;
    }

    protected void keyTyped(char c, int i) {
    }

    public void initGui() {
        controlList.clear();
    }

    public void updateScreen() {
        updateCounter++;
        if (updateCounter % 20 == 0) {
            netHandler.addToSendQueue(new Packet0KeepAlive());
        }
        if (netHandler != null) {
            netHandler.processReadPackets();
        }
    }

    protected void actionPerformed(GuiButton guibutton) {
    }

    public void drawScreen(int i, int j, float f) {
        drawBackground(0);
        drawCenteredString(fontRenderer, "Downloading terrain", width / 2, height / 2 - 50, 0xffffff);
        super.drawScreen(i, j, f);
    }
}

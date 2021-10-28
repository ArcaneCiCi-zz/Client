package net.minecraft.client.thread;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.impl.GuiConnectFailed;
import net.minecraft.client.gui.impl.GuiConnecting;
import net.minecraft.client.network.manager.NetClientHandler;
import net.minecraft.client.network.packet.impl.Packet2Handshake;

import java.net.ConnectException;
import java.net.UnknownHostException;

public class ThreadConnectToServer extends Thread {

    final Minecraft mc;
    final String hostName;
    final int port;
    final GuiConnecting connectingGui;
    public ThreadConnectToServer(GuiConnecting guiconnecting, Minecraft minecraft, String s, int i) {
        connectingGui = guiconnecting;
        mc = minecraft;
        hostName = s;
        port = i;
    }

    public void run() {
        try {
            GuiConnecting.setNetClientHandler(connectingGui, new NetClientHandler(mc, hostName, port));
            if (GuiConnecting.isCancelled(connectingGui)) {
                return;
            }
            GuiConnecting.getNetClientHandler(connectingGui).addToSendQueue(new Packet2Handshake(mc.session.userName));
        } catch (UnknownHostException unknownhostexception) {
            if (GuiConnecting.isCancelled(connectingGui)) {
                return;
            }
            mc.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", (new StringBuilder()).append("Unknown host '").append(hostName).append("'").toString()));
        } catch (ConnectException connectexception) {
            if (GuiConnecting.isCancelled(connectingGui)) {
                return;
            }
            mc.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", connectexception.getMessage()));
        } catch (Exception exception) {
            if (GuiConnecting.isCancelled(connectingGui)) {
                return;
            }
            exception.printStackTrace();
            mc.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", exception.toString()));
        }
    }
}

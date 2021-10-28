package net.minecraft.client;

import net.minecraft.client.impl.MinecraftAppletImpl;
import net.minecraft.client.session.Session;
import net.minecraft.client.texture.canvas.CanvasMinecraftApplet;

import java.applet.Applet;
import java.awt.*;


public class MinecraftApplet extends Applet {

    private Canvas mcCanvas;
    private Minecraft mc;
    private Thread mcThread;

    public MinecraftApplet() {
        mcThread = null;
    }

    public void init() {
        mcCanvas = new CanvasMinecraftApplet(this);
        boolean flag = false;
        if (getParameter("fullscreen") != null) {
            flag = getParameter("fullscreen").equalsIgnoreCase("true");
        }
        mc = new MinecraftAppletImpl(this, this, mcCanvas, this, getWidth(), getHeight(), flag);
        mc.field_6319_j = getDocumentBase().getHost();
        if (getDocumentBase().getPort() > 0) {
            mc.field_6319_j += ":" + getDocumentBase().getPort();
        }
        if (getParameter("username") != null && getParameter("sessionid") != null) {
            mc.session = new Session(getParameter("username"), getParameter("sessionid"));
            System.out.println((new StringBuilder()).append("Setting user: ").append(mc.session.userName).append(", ").append(mc.session.field_6543_c));
            if (getParameter("mppass") != null) {
                mc.session.field_6542_d = getParameter("mppass");
            }
        } else {
            mc.session = new Session("Player", "");
        }
        if (getParameter("loadmap_user") != null && getParameter("loadmap_id") != null) {
            mc.field_6310_s = getParameter("loadmap_user");
            mc.field_6309_t = Integer.parseInt(getParameter("loadmap_id"));
        } else if (getParameter("server") != null && getParameter("port") != null) {
            mc.func_6258_a(getParameter("server"), Integer.parseInt(getParameter("port")));
        }
        mc.field_6317_l = true;
        setLayout(new BorderLayout());
        add(mcCanvas, "Center");
        mcCanvas.setFocusable(true);
        validate();
        return;
    }

    public void func_6233_a() {
        if (mcThread != null) {
            return;
        } else {
            mcThread = new Thread(mc, "Minecraft main thread");
            mcThread.start();
            return;
        }
    }

    public void start() {
        if (mc != null) {
            mc.field_6316_m = false;
        }
    }

    public void stop() {
        if (mc != null) {
            mc.field_6316_m = true;
        }
    }

    public void destroy() {
        shutdown();
    }

    public void shutdown() {
        if (mcThread == null) {
            return;
        }
        mc.shutdown();
        try {
            mcThread.join(10000L);
        } catch (InterruptedException interruptedexception) {
            try {
                mc.func_6266_c();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        mcThread = null;
    }

    public void func_6231_c() {
        mcCanvas = null;
        mc = null;
        mcThread = null;
        try {
            removeAll();
            validate();
        } catch (Exception exception) {
        }
    }
}

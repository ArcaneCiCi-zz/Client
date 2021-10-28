package net.minecraft.client.texture.canvas;


import java.awt.*;

public class CanvasCrashReport extends Canvas {

    public CanvasCrashReport(int i) {
        setPreferredSize(new Dimension(i, i));
        setMinimumSize(new Dimension(i, i));
    }
}

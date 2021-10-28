package net.minecraft.client.impl;


import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.client.misc.PanelCrashReport;
import net.minecraft.client.misc.UnexpectedThrowable;

import java.awt.*;

public final class MinecraftImpl extends Minecraft {

    final Frame mainFrame;

    public MinecraftImpl(Component component, Canvas canvas, MinecraftApplet minecraftapplet, int i, int j, boolean flag, Frame frame) {
        super(component, canvas, minecraftapplet, i, j, flag);
        mainFrame = frame;
    }

    public void func_4007_a(UnexpectedThrowable unexpectedthrowable) {
        mainFrame.removeAll();
        mainFrame.add(new PanelCrashReport(unexpectedthrowable), "Center");
        mainFrame.validate();
    }
}

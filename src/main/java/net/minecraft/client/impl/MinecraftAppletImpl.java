package net.minecraft.client.impl;


import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.client.misc.PanelCrashReport;
import net.minecraft.client.misc.UnexpectedThrowable;

import java.awt.*;

public class MinecraftAppletImpl extends Minecraft {

    final MinecraftApplet mainFrame;

    public MinecraftAppletImpl(MinecraftApplet minecraftapplet, Component component, Canvas canvas, MinecraftApplet minecraftapplet1, int i, int j, boolean flag) {
        super(component, canvas, minecraftapplet1, i, j, flag);
        mainFrame = minecraftapplet;
    }

    public void func_4007_a(UnexpectedThrowable unexpectedthrowable) {
        mainFrame.removeAll();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(new PanelCrashReport(unexpectedthrowable), "Center");
        mainFrame.validate();
    }
}

package net.minecraft.client.render.impl;


import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

import java.awt.*;
import java.nio.IntBuffer;

public class MouseHelper {

    private final Component field_1117_c;
    private final int field_1115_e;
    public int field_1114_a;
    public int field_1113_b;
    private Cursor field_1116_d;
    public MouseHelper(Component component) {
        field_1115_e = 10;
        field_1117_c = component;
        IntBuffer intbuffer = GLAllocation.createDirectIntBuffer(1);
        intbuffer.put(0);
        intbuffer.flip();
        IntBuffer intbuffer1 = GLAllocation.createDirectIntBuffer(1024);
        try {
            field_1116_d = new Cursor(32, 32, 16, 16, 1, intbuffer1, intbuffer);
        } catch (LWJGLException lwjglexception) {
            lwjglexception.printStackTrace();
        }
    }

    public void func_774_a() {
        Mouse.setGrabbed(true);
        field_1114_a = 0;
        field_1113_b = 0;
    }

    public void func_773_b() {
        Mouse.setCursorPosition(field_1117_c.getWidth() / 2, field_1117_c.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void func_772_c() {
        field_1114_a = Mouse.getDX();
        field_1113_b = Mouse.getDY();
    }
}

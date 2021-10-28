package net.minecraft.client.render.impl;


import org.lwjgl.opengl.GL11;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class GLAllocation {

    private static final List displayLists = new ArrayList<>();
    private static final List textureNames = new ArrayList<>();

    public GLAllocation() {
    }

    public static synchronized int generateDisplayLists(int i) {
        int j = GL11.glGenLists(i);
        displayLists.add(Integer.valueOf(j));
        displayLists.add(Integer.valueOf(i));
        return j;
    }

    public static synchronized void generateTextureNames(IntBuffer intbuffer) {
        GL11.glGenTextures(intbuffer);
        for (int i = intbuffer.position(); i < intbuffer.limit(); i++) {
            textureNames.add(Integer.valueOf(intbuffer.get(i)));
        }

    }

    public static synchronized void deleteTexturesAndDisplayLists() {
        for (int i = 0; i < displayLists.size(); i += 2) {
            GL11.glDeleteLists(((Integer) displayLists.get(i)).intValue(), ((Integer) displayLists.get(i + 1)).intValue());
        }

        IntBuffer intbuffer = createDirectIntBuffer(textureNames.size());
        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        for (int j = 0; j < textureNames.size(); j++) {
            intbuffer.put(((Integer) textureNames.get(j)).intValue());
        }

        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        displayLists.clear();
        textureNames.clear();
    }

    public static synchronized ByteBuffer createDirectByteBuffer(int i) {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        return bytebuffer;
    }

    public static IntBuffer createDirectIntBuffer(int i) {
        return createDirectByteBuffer(i << 2).asIntBuffer();
    }

    public static FloatBuffer createDirectFloatBuffer(int i) {
        return createDirectByteBuffer(i << 2).asFloatBuffer();
    }

}

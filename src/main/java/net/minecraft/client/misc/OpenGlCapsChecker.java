package net.minecraft.client.misc;


import org.lwjgl.opengl.GLContext;

public class OpenGlCapsChecker {

    private static final boolean tryCheckOcclusionCapable = false;

    public OpenGlCapsChecker() {
    }

    public boolean checkARBOcclusion() {
        return tryCheckOcclusionCapable && GLContext.getCapabilities().GL_ARB_occlusion_query;
    }

}

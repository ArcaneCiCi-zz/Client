package net.minecraft.client.world.tile;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.entity.mob.render.RenderEngine;
import net.minecraft.client.ui.font.FontRenderer;
import net.minecraft.client.world.World;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TileEntityRenderer {

    public static TileEntityRenderer instance = new TileEntityRenderer();
    public static double staticPlayerX;
    public static double staticPlayerY;
    public static double staticPlayerZ;
    private final Map specialRendererMap;
    public RenderEngine renderEngine;
    public World worldObj;
    public EntityPlayer entityPlayer;
    public float playerYaw;
    public float playerPitch;
    public double playerX;
    public double playerY;
    public double playerZ;
    private FontRenderer fontRenderer;
    private TileEntityRenderer() {
        specialRendererMap = new HashMap();
        specialRendererMap.put(TileEntitySign.class, new TileEntitySignRenderer());
        specialRendererMap.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        TileEntitySpecialRenderer tileentityspecialrenderer;
        for (Iterator iterator = specialRendererMap.values().iterator(); iterator.hasNext(); tileentityspecialrenderer.setTileEntityRenderer(this)) {
            tileentityspecialrenderer = (TileEntitySpecialRenderer) iterator.next();
        }

    }

    public TileEntitySpecialRenderer getSpecialRendererForClass(Class class1) {
        TileEntitySpecialRenderer tileentityspecialrenderer = (TileEntitySpecialRenderer) specialRendererMap.get(class1);
        if (tileentityspecialrenderer == null && class1 != (TileEntity.class)) {
            tileentityspecialrenderer = getSpecialRendererForClass(class1.getSuperclass());
            specialRendererMap.put(class1, tileentityspecialrenderer);
        }
        return tileentityspecialrenderer;
    }

    public boolean hasSpecialRenderer(TileEntity tileentity) {
        return getSpecialRendererForEntity(tileentity) != null;
    }

    public TileEntitySpecialRenderer getSpecialRendererForEntity(TileEntity tileentity) {
        if (tileentity == null) {
            return null;
        } else {
            return getSpecialRendererForClass(tileentity.getClass());
        }
    }

    public void setRenderingContext(World world, RenderEngine renderengine, FontRenderer fontrenderer, EntityPlayer entityplayer, float f) {
        worldObj = world;
        renderEngine = renderengine;
        entityPlayer = entityplayer;
        fontRenderer = fontrenderer;
        playerYaw = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
        playerPitch = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
        playerX = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) * (double) f;
        playerY = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) * (double) f;
        playerZ = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) * (double) f;
    }

    public void renderTileEntity(TileEntity tileentity, float f) {
        if (tileentity.getDistanceFrom(playerX, playerY, playerZ) < 4096D) {
            float f1 = worldObj.getLightBrightness(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
            GL11.glColor3f(f1, f1, f1);
            renderTileEntityAt(tileentity, (double) tileentity.xCoord - staticPlayerX, (double) tileentity.yCoord - staticPlayerY, (double) tileentity.zCoord - staticPlayerZ, f);
        }
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2,
                                   float f) {
        TileEntitySpecialRenderer tileentityspecialrenderer = getSpecialRendererForEntity(tileentity);
        if (tileentityspecialrenderer != null) {
            tileentityspecialrenderer.renderTileEntityAt(tileentity, d, d1, d2, f);
        }
    }

    public FontRenderer getFontRenderer() {
        return fontRenderer;
    }

}

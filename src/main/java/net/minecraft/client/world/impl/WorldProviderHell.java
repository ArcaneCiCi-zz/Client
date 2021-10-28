package net.minecraft.client.world.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.mob.render.MobSpawnerBase;
import net.minecraft.client.render.impl.Vec3D;
import net.minecraft.client.world.chunk.IChunkLoader;
import net.minecraft.client.world.chunk.IChunkProvider;
import net.minecraft.client.world.chunk.impl.ChunkLoader;
import net.minecraft.client.world.chunk.impl.ChunkProviderHell;

import java.io.File;

public class WorldProviderHell extends WorldProvider {

    public WorldProviderHell() {
    }

    public void registerWorldChunkManager() {
        worldChunkMgr = new WorldChunkManagerHell(MobSpawnerBase.hell, 1.0D, 0.0D);
        field_4220_c = true;
        field_6479_d = true;
        field_6478_e = true;
        field_4218_e = -1;
    }

    public Vec3D func_4096_a(float f, float f1) {
        return Vec3D.createVector(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
    }

    protected void generateLightBrightnessTable() {
        float f = 0.1F;
        for (int i = 0; i <= 15; i++) {
            float f1 = 1.0F - (float) i / 15F;
            lightBrightnessTable[i] = ((1.0F - f1) / (f1 * 3F + 1.0F)) * (1.0F - f) + f;
        }

    }

    public IChunkProvider getChunkProvider() {
        return new ChunkProviderHell(worldObj, worldObj.randomSeed);
    }

    public IChunkLoader getChunkLoader(File file) {
        File file1 = new File(file, "DIM-1");
        file1.mkdirs();
        return new ChunkLoader(file1, true);
    }

    public boolean canCoordinateBeSpawn(int i, int j) {
        int k = worldObj.func_614_g(i, j);
        if (k == Block.bedrock.blockID) {
            return false;
        }
        if (k == 0) {
            return false;
        }
        return Block.opaqueCubeLookup[k];
    }

    public float calculateCelestialAngle(long l, float f) {
        return 0.5F;
    }

    public boolean func_6477_d() {
        return false;
    }
}

package net.minecraft.client.world.chunk.impl;


import net.minecraft.client.interfaces.IProgressUpdate;
import net.minecraft.client.world.World;
import net.minecraft.client.world.chunk.Chunk;
import net.minecraft.client.world.chunk.IChunkLoader;
import net.minecraft.client.world.chunk.IChunkProvider;

import java.io.IOException;

public class ChunkProviderIso
        implements IChunkProvider {

    private final Chunk[] chunks;
    private final World worldObj;
    private final IChunkLoader chunkLoader;
    byte[] field_899_a;

    public ChunkProviderIso(World world, IChunkLoader ichunkloader) {
        chunks = new Chunk[256];
        field_899_a = new byte[32768];
        worldObj = world;
        chunkLoader = ichunkloader;
    }

    public boolean chunkExists(int i, int j) {
        int k = i & 0xf | (j & 0xf) * 16;
        return chunks[k] != null && chunks[k].isAtLocation(i, j);
    }

    public Chunk provideChunk(int i, int j) {
        int k = i & 0xf | (j & 0xf) * 16;
        try {
            if (!chunkExists(i, j)) {
                Chunk chunk = func_543_c(i, j);
                if (chunk == null) {
                    chunk = new Chunk(worldObj, field_899_a, i, j);
                    chunk.field_1524_q = true;
                    chunk.neverSave = true;
                }
                chunks[k] = chunk;
            }
            return chunks[k];
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private synchronized Chunk func_543_c(int i, int j) {
        try {
            return chunkLoader.loadChunk(worldObj, i, j);
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
        return null;
    }

    public void populate(IChunkProvider ichunkprovider, int i, int j) {
    }

    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    public boolean func_532_a() {
        return false;
    }

    public boolean func_536_b() {
        return false;
    }
}

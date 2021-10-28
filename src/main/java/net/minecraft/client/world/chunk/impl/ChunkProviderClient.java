package net.minecraft.client.world.chunk.impl;


import net.minecraft.client.interfaces.IProgressUpdate;
import net.minecraft.client.world.World;
import net.minecraft.client.world.chunk.Chunk;
import net.minecraft.client.world.chunk.IChunkProvider;

import java.util.*;

public class ChunkProviderClient implements IChunkProvider {

    private final Chunk blankChunk;
    private final Map chunkMapping;
    private final List unusedChunkList;
    private final World worldObj;

    public ChunkProviderClient(World world) {
        chunkMapping = new HashMap();
        unusedChunkList = new ArrayList<>();
        blankChunk = new Chunk(world, new byte[32768], 0, 0);
        blankChunk.field_1524_q = true;
        blankChunk.neverSave = true;
        worldObj = world;
    }

    public boolean chunkExists(int i, int j) {
        ChunkCoordinates chunkcoordinates = new ChunkCoordinates(i, j);
        return chunkMapping.containsKey(chunkcoordinates);
    }

    public void func_539_c(int i, int j) {
        Chunk chunk = provideChunk(i, j);
        if (!chunk.field_1524_q) {
            chunk.onChunkUnload();
        }
        chunkMapping.remove(new ChunkCoordinates(i, j));
        unusedChunkList.remove(chunk);
    }

    public Chunk func_538_d(int i, int j) {
        ChunkCoordinates chunkcoordinates = new ChunkCoordinates(i, j);
        byte[] abyte0 = new byte[32768];
        Chunk chunk = new Chunk(worldObj, abyte0, i, j);
        Arrays.fill(chunk.skylightMap.data, (byte) -1);
        chunkMapping.put(chunkcoordinates, chunk);
        chunk.isChunkLoaded = true;
        return chunk;
    }

    public Chunk provideChunk(int i, int j) {
        ChunkCoordinates chunkcoordinates = new ChunkCoordinates(i, j);
        Chunk chunk = (Chunk) chunkMapping.get(chunkcoordinates);
        if (chunk == null) {
            return blankChunk;
        } else {
            return chunk;
        }
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

    public void populate(IChunkProvider ichunkprovider, int i, int j) {
    }
}

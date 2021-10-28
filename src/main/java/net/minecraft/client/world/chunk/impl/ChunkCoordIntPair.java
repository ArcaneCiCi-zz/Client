package net.minecraft.client.world.chunk.impl;


public class ChunkCoordIntPair {

    public int chunkXPos;
    public int chunkZPos;

    public ChunkCoordIntPair(int i, int j) {
        chunkXPos = i;
        chunkZPos = j;
    }

    public int hashCode() {
        return chunkXPos << 8 | chunkZPos;
    }

    public boolean equals(Object obj) {
        ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair) obj;
        return chunkcoordintpair.chunkXPos == chunkXPos && chunkcoordintpair.chunkZPos == chunkZPos;
    }
}

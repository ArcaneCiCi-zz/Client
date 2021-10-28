package net.minecraft.client.world.chunk.impl;


public class ChunkPosition {

    public final int x;
    public final int y;
    public final int z;

    public ChunkPosition(int i, int j, int k) {
        x = i;
        y = j;
        z = k;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChunkPosition) {
            ChunkPosition chunkposition = (ChunkPosition) obj;
            return chunkposition.x == x && chunkposition.y == y && chunkposition.z == z;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return x * 0x88f9fa + y * 0xef88b + z;
    }
}

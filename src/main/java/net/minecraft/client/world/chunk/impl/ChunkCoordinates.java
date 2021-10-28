package net.minecraft.client.world.chunk.impl;


final class ChunkCoordinates {

    public final int field_1518_a;
    public final int field_1517_b;

    public ChunkCoordinates(int i, int j) {
        field_1518_a = i;
        field_1517_b = j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChunkCoordinates) {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates) obj;
            return field_1518_a == chunkcoordinates.field_1518_a && field_1517_b == chunkcoordinates.field_1517_b;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return field_1518_a << 16 ^ field_1517_b;
    }
}

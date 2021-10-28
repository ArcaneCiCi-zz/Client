package net.minecraft.client.world.chunk;


import net.minecraft.client.world.World;

import java.io.IOException;

public interface IChunkLoader {

    Chunk loadChunk(World world, int i, int j) throws IOException;

    void saveChunk(World world, Chunk chunk) throws IOException;

    void saveExtraChunkData(World world, Chunk chunk) throws IOException;

    void func_814_a();

    void saveExtraData();
}

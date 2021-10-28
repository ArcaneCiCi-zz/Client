package net.minecraft.client.world.chunk;


import net.minecraft.client.interfaces.IProgressUpdate;

public interface IChunkProvider {

    boolean chunkExists(int i, int j);

    Chunk provideChunk(int i, int j);

    void populate(IChunkProvider ichunkprovider, int i, int j);

    boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate);

    boolean func_532_a();

    boolean func_536_b();
}

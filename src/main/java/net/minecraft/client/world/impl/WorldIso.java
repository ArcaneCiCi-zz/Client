package net.minecraft.client.world.impl;


import net.minecraft.client.texture.canvas.CanvasIsomPreview;
import net.minecraft.client.world.World;
import net.minecraft.client.world.chunk.IChunkProvider;
import net.minecraft.client.world.chunk.impl.ChunkLoader;
import net.minecraft.client.world.chunk.impl.ChunkProviderIso;

import java.io.File;

public class WorldIso extends World {

    final CanvasIsomPreview field_1051_z;

    public WorldIso(CanvasIsomPreview canvasisompreview, File file, String s) {
        super(file, s);
        field_1051_z = canvasisompreview;
    }

    protected IChunkProvider func_4081_a(File file) {
        return new ChunkProviderIso(this, new ChunkLoader(file, false));
    }
}

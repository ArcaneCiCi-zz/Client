package net.minecraft.client.interfaces;


import net.minecraft.client.item.material.Material;
import net.minecraft.client.world.impl.WorldChunkManager;
import net.minecraft.client.world.tile.TileEntity;

public interface IBlockAccess {

    int getBlockId(int i, int j, int k);

    TileEntity getBlockTileEntity(int i, int j, int k);

    float getLightBrightness(int i, int j, int k);

    int getBlockMetadata(int i, int j, int k);

    Material getBlockMaterial(int i, int j, int k);

    boolean isBlockOpaqueCube(int i, int j, int k);

    WorldChunkManager func_4075_a();
}

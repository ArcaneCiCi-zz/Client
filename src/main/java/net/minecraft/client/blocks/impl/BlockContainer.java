package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.world.World;
import net.minecraft.client.world.tile.TileEntity;

public abstract class BlockContainer extends Block {

    protected BlockContainer(int i, Material material) {
        super(i, material);
        isBlockContainer[i] = true;
    }

    protected BlockContainer(int i, int j, Material material) {
        super(i, j, material);
    }

    public void onBlockAdded(World world, int i, int j, int k) {
        super.onBlockAdded(world, i, j, k);
        world.setBlockTileEntity(i, j, k, SetBlockEntity());
    }

    public void onBlockRemoval(World world, int i, int j, int k) {
        super.onBlockRemoval(world, i, j, k);
        world.removeBlockTileEntity(i, j, k);
    }

    protected abstract TileEntity SetBlockEntity();
}

package net.minecraft.client.blocks.impl;


import net.minecraft.client.item.material.Material;
import net.minecraft.client.world.tile.TileEntity;
import net.minecraft.client.world.tile.TileEntityMobSpawner;

import java.util.Random;

public class BlockMobSpawner extends BlockContainer {

    public BlockMobSpawner(int i, int j) {
        super(i, j, Material.rock);
    }

    protected TileEntity SetBlockEntity() {
        return new TileEntityMobSpawner();
    }

    public int idDropped(int i, Random random) {
        return 0;
    }

    public int quantityDropped(Random random) {
        return 0;
    }

    public boolean isOpaqueCube() {
        return false;
    }
}

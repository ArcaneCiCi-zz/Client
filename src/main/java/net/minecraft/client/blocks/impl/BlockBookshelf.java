package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.material.Material;

import java.util.Random;

public class BlockBookshelf extends Block {

    public BlockBookshelf(int i, int j) {
        super(i, j, Material.wood);
    }

    public int getBlockTextureFromSide(int i) {
        if (i <= 1) {
            return 4;
        } else {
            return blockIndexInTexture;
        }
    }

    public int quantityDropped(Random random) {
        return 0;
    }
}

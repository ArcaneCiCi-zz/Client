package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.material.Material;

import java.util.Random;

public class BlockLog extends Block {

    public BlockLog(int i) {
        super(i, Material.wood);
        blockIndexInTexture = 20;
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public int idDropped(int i, Random random) {
        return Block.wood.blockID;
    }

    public int getBlockTextureFromSide(int i) {
        if (i == 1) {
            return 21;
        }
        return i != 0 ? 20 : 21;
    }
}

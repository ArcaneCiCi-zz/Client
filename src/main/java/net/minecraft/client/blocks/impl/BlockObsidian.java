package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;

import java.util.Random;

public class BlockObsidian extends BlockStone {

    public BlockObsidian(int i, int j) {
        super(i, j);
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public int idDropped(int i, Random random) {
        return Block.obsidian.blockID;
    }
}

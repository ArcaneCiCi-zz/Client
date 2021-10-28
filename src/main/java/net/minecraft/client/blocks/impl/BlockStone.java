package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.material.Material;

import java.util.Random;

public class BlockStone extends Block {

    public BlockStone(int i, int j) {
        super(i, j, Material.rock);
    }

    public int idDropped(int i, Random random) {
        return Block.cobblestone.blockID;
    }
}

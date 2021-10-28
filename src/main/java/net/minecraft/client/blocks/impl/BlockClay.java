package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.material.Material;

import java.util.Random;

public class BlockClay extends Block {

    public BlockClay(int i, int j) {
        super(i, j, Material.clay);
    }

    public int idDropped(int i, Random random) {
        return Item.clay.shiftedIndex;
    }

    public int quantityDropped(Random random) {
        return 4;
    }
}

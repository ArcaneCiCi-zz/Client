package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.material.Material;

import java.util.Random;

public class BlockLightStone extends Block {

    public BlockLightStone(int i, int j, Material material) {
        super(i, j, material);
    }

    public int idDropped(int i, Random random) {
        return Item.lightStoneDust.shiftedIndex;
    }
}

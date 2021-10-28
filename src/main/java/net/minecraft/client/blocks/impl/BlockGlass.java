package net.minecraft.client.blocks.impl;


import net.minecraft.client.item.material.Material;

import java.util.Random;

public class BlockGlass extends BlockBreakable {

    public BlockGlass(int i, int j, Material material, boolean flag) {
        super(i, j, material, flag);
    }

    public int quantityDropped(Random random) {
        return 0;
    }
}

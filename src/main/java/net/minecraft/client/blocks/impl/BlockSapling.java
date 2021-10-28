package net.minecraft.client.blocks.impl;


import net.minecraft.client.world.World;
import net.minecraft.client.world.impl.WorldGenBigTree;
import net.minecraft.client.world.impl.WorldGenTrees;
import net.minecraft.client.world.impl.WorldGenerator;

import java.util.Random;

public class BlockSapling extends BlockFlower {

    public BlockSapling(int i, int j) {
        super(i, j);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    public void updateTick(World world, int i, int j, int k, Random random) {
        super.updateTick(world, i, j, k, random);
        if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(5) == 0) {
            int l = world.getBlockMetadata(i, j, k);
            if (l < 15) {
                world.setBlockMetadataWithNotify(i, j, k, l + 1);
            } else {
                world.setBlock(i, j, k, 0);
                Object obj = new WorldGenTrees();
                if (random.nextInt(10) == 0) {
                    obj = new WorldGenBigTree();
                }
                if (!((WorldGenerator) (obj)).generate(world, random, i, j, k)) {
                    world.setBlock(i, j, k, blockID);
                }
            }
        }
    }
}

package net.minecraft.client.world.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.world.World;

import java.util.Random;

public class WorldGenFlowers extends WorldGenerator {

    private final int plantBlockId;

    public WorldGenFlowers(int i) {
        plantBlockId = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        for (int l = 0; l < 64; l++) {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = (j + random.nextInt(4)) - random.nextInt(4);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);
            if (world.getBlockId(i1, j1, k1) == 0 && (Block.blocksList[plantBlockId]).canBlockStay(world, i1, j1, k1)) {
                world.setBlock(i1, j1, k1, plantBlockId);
            }
        }

        return true;
    }
}

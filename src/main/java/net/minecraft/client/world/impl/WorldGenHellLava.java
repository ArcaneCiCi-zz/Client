package net.minecraft.client.world.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.world.World;

import java.util.Random;

public class WorldGenHellLava extends WorldGenerator {

    private final int field_4158_a;

    public WorldGenHellLava(int i) {
        field_4158_a = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        if (world.getBlockId(i, j + 1, k) != Block.bloodStone.blockID) {
            return false;
        }
        if (world.getBlockId(i, j, k) != 0 && world.getBlockId(i, j, k) != Block.bloodStone.blockID) {
            return false;
        }
        int l = 0;
        if (world.getBlockId(i - 1, j, k) == Block.bloodStone.blockID) {
            l++;
        }
        if (world.getBlockId(i + 1, j, k) == Block.bloodStone.blockID) {
            l++;
        }
        if (world.getBlockId(i, j, k - 1) == Block.bloodStone.blockID) {
            l++;
        }
        if (world.getBlockId(i, j, k + 1) == Block.bloodStone.blockID) {
            l++;
        }
        if (world.getBlockId(i, j - 1, k) == Block.bloodStone.blockID) {
            l++;
        }
        int i1 = 0;
        if (world.getBlockId(i - 1, j, k) == 0) {
            i1++;
        }
        if (world.getBlockId(i + 1, j, k) == 0) {
            i1++;
        }
        if (world.getBlockId(i, j, k - 1) == 0) {
            i1++;
        }
        if (world.getBlockId(i, j, k + 1) == 0) {
            i1++;
        }
        if (world.getBlockId(i, j - 1, k) == 0) {
            i1++;
        }
        if (l == 4 && i1 == 1) {
            world.setBlockWithNotify(i, j, k, field_4158_a);
            world.field_4214_a = true;
            Block.blocksList[field_4158_a].updateTick(world, i, j, k, random);
            world.field_4214_a = false;
        }
        return true;
    }
}

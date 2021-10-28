package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.world.World;

public class BlockMushroom extends BlockFlower {

    public BlockMushroom(int i, int j) {
        super(i, j);
        float f = 0.2F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i) {
        return Block.opaqueCubeLookup[i];
    }

    public boolean canBlockStay(World world, int i, int j, int k) {
        return world.getBlockLightValue(i, j, k) <= 13 && canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
    }
}

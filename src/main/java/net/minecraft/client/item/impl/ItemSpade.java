package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;

public class ItemSpade extends ItemTool {

    private static final Block[] blocksEffectiveAgainst;

    static {
        blocksEffectiveAgainst = (new Block[]{
                Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay
        });
    }

    public ItemSpade(int i, int j) {
        super(i, 1, j, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block block) {
        if (block == Block.snow) {
            return true;
        }
        return block == Block.blockSnow;
    }
}

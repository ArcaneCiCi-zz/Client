package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;

public class ItemAxe extends ItemTool {

    private static final Block[] blocksEffectiveAgainst;

    static {
        blocksEffectiveAgainst = (new Block[]{
                Block.planks, Block.bookShelf, Block.wood, Block.chest
        });
    }

    public ItemAxe(int i, int j) {
        super(i, 3, j, blocksEffectiveAgainst);
    }
}

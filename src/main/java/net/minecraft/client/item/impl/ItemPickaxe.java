package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.material.Material;

public class ItemPickaxe extends ItemTool {

    private static final Block[] blocksEffectiveAgainst;

    static {
        blocksEffectiveAgainst = (new Block[]{
                Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold,
                Block.oreDiamond, Block.blockDiamond, Block.blockIce, Block.bloodStone
        });
    }

    private final int field_328_aY;
    public ItemPickaxe(int i, int j) {
        super(i, 2, j, blocksEffectiveAgainst);
        field_328_aY = j;
    }

    public boolean canHarvestBlock(Block block) {
        if (block == Block.obsidian) {
            return field_328_aY == 3;
        }
        if (block == Block.blockDiamond || block == Block.oreDiamond) {
            return field_328_aY >= 2;
        }
        if (block == Block.blockGold || block == Block.oreGold) {
            return field_328_aY >= 2;
        }
        if (block == Block.blockSteel || block == Block.oreIron) {
            return field_328_aY >= 1;
        }
        if (block == Block.oreRedstone || block == Block.oreRedstoneGlowing) {
            return field_328_aY >= 2;
        }
        if (block.blockMaterial == Material.rock) {
            return true;
        }
        return block.blockMaterial == Material.iron;
    }
}

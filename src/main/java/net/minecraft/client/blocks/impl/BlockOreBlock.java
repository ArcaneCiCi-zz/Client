package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.material.Material;

public class BlockOreBlock extends Block {

    public BlockOreBlock(int i, int j) {
        super(i, Material.iron);
        blockIndexInTexture = j;
    }

    public int getBlockTextureFromSide(int i) {
        return blockIndexInTexture - 16;
    }
}

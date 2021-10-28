package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.interfaces.IBlockAccess;
import net.minecraft.client.item.material.Material;

public class BlockLeavesBase extends Block {

    protected boolean graphicsLevel;

    protected BlockLeavesBase(int i, int j, Material material, boolean flag) {
        super(i, j, material);
        graphicsLevel = flag;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        int i1 = iblockaccess.getBlockId(i, j, k);
        if (!graphicsLevel && i1 == blockID) {
            return false;
        } else {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }
}

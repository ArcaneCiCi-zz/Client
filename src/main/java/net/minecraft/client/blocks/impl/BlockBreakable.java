package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.interfaces.IBlockAccess;
import net.minecraft.client.item.material.Material;

public class BlockBreakable extends Block {

    private final boolean field_6363_a;

    protected BlockBreakable(int i, int j, Material material, boolean flag) {
        super(i, j, material);
        field_6363_a = flag;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        int i1 = iblockaccess.getBlockId(i, j, k);
        if (!field_6363_a && i1 == blockID) {
            return false;
        } else {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }
}

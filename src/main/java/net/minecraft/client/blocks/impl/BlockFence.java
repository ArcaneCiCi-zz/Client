package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.render.impl.AxisAlignedBB;
import net.minecraft.client.world.World;

import java.util.ArrayList;

public class BlockFence extends Block {

    public BlockFence(int i, int j) {
        super(i, j, Material.wood);
    }

    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        arraylist.add(AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, (double) j + 1.5D, k + 1));
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k) {
        if (world.getBlockId(i, j - 1, k) == blockID) {
            return false;
        }
        if (!world.getBlockMaterial(i, j - 1, k).func_878_a()) {
            return false;
        } else {
            return super.canPlaceBlockAt(world, i, j, k);
        }
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 11;
    }
}

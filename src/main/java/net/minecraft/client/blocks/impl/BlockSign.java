package net.minecraft.client.blocks.impl;


import net.minecraft.client.interfaces.IBlockAccess;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.render.impl.AxisAlignedBB;
import net.minecraft.client.world.World;
import net.minecraft.client.world.tile.TileEntity;

import java.util.Random;

public class BlockSign extends BlockContainer {

    private final Class signEntityClass;
    private final boolean isFreestanding;

    public BlockSign(int i, Class class1, boolean flag) {
        super(i, Material.wood);
        isFreestanding = flag;
        blockIndexInTexture = 4;
        signEntityClass = class1;
        float f = 0.25F;
        float f1 = 1.0F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        return null;
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k) {
        setBlockBoundsBasedOnState(world, i, j, k);
        return super.getSelectedBoundingBoxFromPool(world, i, j, k);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k) {
        if (isFreestanding) {
            return;
        }
        int l = iblockaccess.getBlockMetadata(i, j, k);
        float f = 0.28125F;
        float f1 = 0.78125F;
        float f2 = 0.0F;
        float f3 = 1.0F;
        float f4 = 0.125F;
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if (l == 2) {
            setBlockBounds(f2, f, 1.0F - f4, f3, f1, 1.0F);
        }
        if (l == 3) {
            setBlockBounds(f2, f, 0.0F, f3, f1, f4);
        }
        if (l == 4) {
            setBlockBounds(1.0F - f4, f, f2, 1.0F, f1, f3);
        }
        if (l == 5) {
            setBlockBounds(0.0F, f, f2, f4, f1, f3);
        }
    }

    public int getRenderType() {
        return -1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    protected TileEntity SetBlockEntity() {
        try {
            return (TileEntity) signEntityClass.newInstance();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public int idDropped(int i, Random random) {
        return Item.sign.shiftedIndex;
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
        boolean flag = false;
        if (isFreestanding) {
            if (!world.getBlockMaterial(i, j - 1, k).func_878_a()) {
                flag = true;
            }
        } else {
            int i1 = world.getBlockMetadata(i, j, k);
            flag = i1 != 2 || !world.getBlockMaterial(i, j, k + 1).func_878_a();
            if (i1 == 3 && world.getBlockMaterial(i, j, k - 1).func_878_a()) {
                flag = false;
            }
            if (i1 == 4 && world.getBlockMaterial(i + 1, j, k).func_878_a()) {
                flag = false;
            }
            if (i1 == 5 && world.getBlockMaterial(i - 1, j, k).func_878_a()) {
                flag = false;
            }
        }
        if (flag) {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        }
        super.onNeighborBlockChange(world, i, j, k, l);
    }
}

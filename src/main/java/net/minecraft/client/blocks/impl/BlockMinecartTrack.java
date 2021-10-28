package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.interfaces.IBlockAccess;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.misc.MinecartTrackLogic;
import net.minecraft.client.render.impl.AxisAlignedBB;
import net.minecraft.client.render.impl.MovingObjectPosition;
import net.minecraft.client.render.impl.Vec3D;
import net.minecraft.client.world.World;

import java.util.Random;

public class BlockMinecartTrack extends Block {

    public BlockMinecartTrack(int i, int j) {
        super(i, j, Material.circuits);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public MovingObjectPosition collisionRayTrace(World world, int i, int j, int k, Vec3D vec3d, Vec3D vec3d1) {
        setBlockBoundsBasedOnState(world, i, j, k);
        return super.collisionRayTrace(world, i, j, k, vec3d, vec3d1);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k) {
        int l = iblockaccess.getBlockMetadata(i, j, k);
        if (l >= 2 && l <= 5) {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
        } else {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j) {
        if (j >= 6) {
            return blockIndexInTexture - 16;
        } else {
            return blockIndexInTexture;
        }
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 9;
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k) {
        return world.isBlockOpaqueCube(i, j - 1, k);
    }

    public void onBlockAdded(World world, int i, int j, int k) {
        if (!world.multiplayerWorld) {
            world.setBlockMetadataWithNotify(i, j, k, 15);
            func_4031_h(world, i, j, k);
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
        if (world.multiplayerWorld) {
            return;
        }
        int i1 = world.getBlockMetadata(i, j, k);
        boolean flag = !world.isBlockOpaqueCube(i, j - 1, k);
        if (i1 == 2 && !world.isBlockOpaqueCube(i + 1, j, k)) {
            flag = true;
        }
        if (i1 == 3 && !world.isBlockOpaqueCube(i - 1, j, k)) {
            flag = true;
        }
        if (i1 == 4 && !world.isBlockOpaqueCube(i, j, k - 1)) {
            flag = true;
        }
        if (i1 == 5 && !world.isBlockOpaqueCube(i, j, k + 1)) {
            flag = true;
        }
        if (flag) {
            dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k));
            world.setBlockWithNotify(i, j, k, 0);
        } else if (l > 0 && Block.blocksList[l].canProvidePower() && MinecartTrackLogic.func_791_a(new MinecartTrackLogic(this, world, i, j, k)) == 3) {
            func_4031_h(world, i, j, k);
        }
    }

    private void func_4031_h(World world, int i, int j, int k) {
        if (world.multiplayerWorld) {
            return;
        } else {
            (new MinecartTrackLogic(this, world, i, j, k)).func_792_a(world.isBlockIndirectlyGettingPowered(i, j, k));
            return;
        }
    }
}

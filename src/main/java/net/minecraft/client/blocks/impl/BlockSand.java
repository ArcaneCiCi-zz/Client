package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.mob.impl.EntityFallingSand;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.world.World;

import java.util.Random;

public class BlockSand extends Block {

    public static boolean fallInstantly = false;

    public BlockSand(int i, int j) {
        super(i, j, Material.sand);
    }

    public static boolean canFallBelow(World world, int i, int j, int k) {
        int l = world.getBlockId(i, j, k);
        if (l == 0) {
            return true;
        }
        if (l == Block.fire.blockID) {
            return true;
        }
        Material material = Block.blocksList[l].blockMaterial;
        if (material == Material.water) {
            return true;
        }
        return material == Material.lava;
    }

    public void onBlockAdded(World world, int i, int j, int k) {
        world.scheduleBlockUpdate(i, j, k, blockID);
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
        world.scheduleBlockUpdate(i, j, k, blockID);
    }

    public void updateTick(World world, int i, int j, int k, Random random) {
        tryToFall(world, i, j, k);
    }

    private void tryToFall(World world, int i, int j, int k) {
        int l = i;
        int i1 = j;
        int j1 = k;
        if (canFallBelow(world, l, i1 - 1, j1) && i1 >= 0) {
            EntityFallingSand entityfallingsand = new EntityFallingSand(world, (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, blockID);
            if (fallInstantly) {
                while (!entityfallingsand.isDead) {
                    entityfallingsand.onUpdate();
                }
            } else {
                world.entityJoinedWorld(entityfallingsand);
            }
        }
    }

    public int tickRate() {
        return 3;
    }

}

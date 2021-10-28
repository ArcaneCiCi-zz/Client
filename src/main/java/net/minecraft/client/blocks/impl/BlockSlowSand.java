package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.Entity;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.render.impl.AxisAlignedBB;
import net.minecraft.client.world.World;

public class BlockSlowSand extends Block {

    public BlockSlowSand(int i, int j) {
        super(i, j, Material.sand);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, (float) (j + 1) - f, k + 1);
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
        entity.motionX *= 0.40000000000000002D;
        entity.motionZ *= 0.40000000000000002D;
    }
}

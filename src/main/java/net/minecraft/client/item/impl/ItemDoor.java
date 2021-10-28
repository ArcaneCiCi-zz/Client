package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.world.World;

public class ItemDoor extends Item {

    private final Material field_321_a;

    public ItemDoor(int i, Material material) {
        super(i);
        field_321_a = material;
        maxDamage = 64;
        maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l != 1) {
            return false;
        }
        j++;
        Block block;
        if (field_321_a == Material.wood) {
            block = Block.doorWood;
        } else {
            block = Block.doorSteel;
        }
        if (!block.canPlaceBlockAt(world, i, j, k)) {
            return false;
        }
        int i1 = MathHelper.floor_double((double) (((entityplayer.rotationYaw + 180F) * 4F) / 360F) - 0.5D) & 3;
        byte byte0 = 0;
        byte byte1 = 0;
        if (i1 == 0) {
            byte1 = 1;
        }
        if (i1 == 1) {
            byte0 = -1;
        }
        if (i1 == 2) {
            byte1 = -1;
        }
        if (i1 == 3) {
            byte0 = 1;
        }
        int j1 = (world.isBlockOpaqueCube(i - byte0, j, k - byte1) ? 1 : 0) + (world.isBlockOpaqueCube(i - byte0, j + 1, k - byte1) ? 1 : 0);
        int k1 = (world.isBlockOpaqueCube(i + byte0, j, k + byte1) ? 1 : 0) + (world.isBlockOpaqueCube(i + byte0, j + 1, k + byte1) ? 1 : 0);
        boolean flag = world.getBlockId(i - byte0, j, k - byte1) == block.blockID || world.getBlockId(i - byte0, j + 1, k - byte1) == block.blockID;
        boolean flag1 = world.getBlockId(i + byte0, j, k + byte1) == block.blockID || world.getBlockId(i + byte0, j + 1, k + byte1) == block.blockID;
        boolean flag2 = false;
        if (flag && !flag1) {
            flag2 = true;
        } else if (k1 > j1) {
            flag2 = true;
        }
        if (flag2) {
            i1 = i1 - 1 & 3;
            i1 += 4;
        }
        world.setBlockWithNotify(i, j, k, block.blockID);
        world.setBlockMetadataWithNotify(i, j, k, i1);
        world.setBlockWithNotify(i, j + 1, k, block.blockID);
        world.setBlockMetadataWithNotify(i, j + 1, k, i1 + 8);
        itemstack.stackSize--;
        return true;
    }
}

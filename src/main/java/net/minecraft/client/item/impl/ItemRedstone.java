package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemRedstone extends Item {

    public ItemRedstone(int i) {
        super(i);
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l == 0) {
            j--;
        }
        if (l == 1) {
            j++;
        }
        if (l == 2) {
            k--;
        }
        if (l == 3) {
            k++;
        }
        if (l == 4) {
            i--;
        }
        if (l == 5) {
            i++;
        }
        if (world.getBlockId(i, j, k) != 0) {
            return false;
        }
        if (Block.redstoneWire.canPlaceBlockAt(world, i, j, k)) {
            itemstack.stackSize--;
            world.setBlockWithNotify(i, j, k, Block.redstoneWire.blockID);
        }
        return true;
    }
}

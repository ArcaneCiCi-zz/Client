package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemRecord extends Item {

    private final String recordName;

    public ItemRecord(int i, String s) {
        super(i);
        recordName = s;
        maxStackSize = 1;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (world.getBlockId(i, j, k) == Block.jukebox.blockID && world.getBlockMetadata(i, j, k) == 0) {
            world.setBlockMetadataWithNotify(i, j, k, (shiftedIndex - Item.record13.shiftedIndex) + 1);
            world.playRecord(recordName, i, j, k);
            itemstack.stackSize--;
            return true;
        } else {
            return false;
        }
    }
}

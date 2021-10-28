package net.minecraft.client.item.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemSoup extends ItemFood {

    public ItemSoup(int i, int j) {
        super(i, j);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        super.onItemRightClick(itemstack, world, entityplayer);
        return new ItemStack(Item.bowlEmpty);
    }
}

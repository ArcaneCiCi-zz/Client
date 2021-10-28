package net.minecraft.client.item.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.entity.mob.impl.EntitySnowball;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemSnowball extends Item {

    public ItemSnowball(int i) {
        super(i);
        maxStackSize = 16;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        itemstack.stackSize--;
        world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!world.multiplayerWorld) {
            world.entityJoinedWorld(new EntitySnowball(world, entityplayer));
        }
        return itemstack;
    }
}

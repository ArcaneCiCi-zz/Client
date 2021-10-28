package net.minecraft.client.item.impl;


import net.minecraft.client.entity.mob.impl.EntityFish;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemFishingRod extends Item {

    public ItemFishingRod(int i) {
        super(i);
        maxDamage = 64;
    }

    public boolean isFull3D() {
        return true;
    }

    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.fishEntity != null) {
            int i = entityplayer.fishEntity.func_4043_i();
            itemstack.damageItem(i);
            entityplayer.func_457_w();
        } else {
            world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!world.multiplayerWorld) {
                world.entityJoinedWorld(new EntityFish(world, entityplayer));
            }
            entityplayer.func_457_w();
        }
        return itemstack;
    }
}

package net.minecraft.client.item.impl;


import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.entity.mob.impl.EntityPig;
import net.minecraft.client.item.Item;

public class ItemSaddle extends Item {

    public ItemSaddle(int i) {
        super(i);
        maxStackSize = 1;
        maxDamage = 64;
    }

    public void func_4019_b(ItemStack itemstack, EntityLiving entityliving) {
        if (entityliving instanceof EntityPig) {
            EntityPig entitypig = (EntityPig) entityliving;
            if (!entitypig.rideable) {
                entitypig.rideable = true;
                itemstack.stackSize--;
            }
        }
    }

    public void hitEntity(ItemStack itemstack, EntityLiving entityliving) {
        func_4019_b(itemstack, entityliving);
    }
}

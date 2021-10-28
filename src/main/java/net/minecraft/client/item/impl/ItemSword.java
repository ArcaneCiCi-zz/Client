package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.Entity;
import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.item.Item;

public class ItemSword extends Item {

    private final int weaponDamage;

    public ItemSword(int i, int j) {
        super(i);
        maxStackSize = 1;
        maxDamage = 32 << j;
        if (j == 3) {
            maxDamage *= 4;
        }
        weaponDamage = 4 + j * 2;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block) {
        return 1.5F;
    }

    public void hitEntity(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.damageItem(1);
    }

    public void hitBlock(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.damageItem(2);
    }

    public int getDamageVsEntity(Entity entity) {
        return weaponDamage;
    }

    public boolean isFull3D() {
        return true;
    }
}

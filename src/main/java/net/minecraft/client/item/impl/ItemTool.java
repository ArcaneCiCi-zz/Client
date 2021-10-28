package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.Entity;
import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.item.Item;

public class ItemTool extends Item {

    private final Block[] blocksEffectiveAgainst;
    private final int damageVsEntity;
    protected int ingredientQuality;
    private float efficiencyOnProperMaterial;

    public ItemTool(int i, int j, int k, Block[] ablock) {
        super(i);
        efficiencyOnProperMaterial = 4F;
        ingredientQuality = k;
        blocksEffectiveAgainst = ablock;
        maxStackSize = 1;
        maxDamage = 32 << k;
        if (k == 3) {
            maxDamage *= 4;
        }
        efficiencyOnProperMaterial = (k + 1) * 2;
        damageVsEntity = j + k;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block) {
        for (Block value : blocksEffectiveAgainst) {
            if (value == block) {
                return efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    public void hitEntity(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.damageItem(2);
    }

    public void hitBlock(ItemStack itemstack, int i, int j, int k, int l) {
        itemstack.damageItem(1);
    }

    public int getDamageVsEntity(Entity entity) {
        return damageVsEntity;
    }

    public boolean isFull3D() {
        return true;
    }
}

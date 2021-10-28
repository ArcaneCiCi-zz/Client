package net.minecraft.client.item.impl;


import net.minecraft.client.entity.mob.impl.EntityPainting;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemPainting extends Item {

    public ItemPainting(int i) {
        super(i);
        maxDamage = 64;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (l == 0) {
            return false;
        }
        if (l == 1) {
            return false;
        }
        byte byte0 = 0;
        if (l == 4) {
            byte0 = 1;
        }
        if (l == 3) {
            byte0 = 2;
        }
        if (l == 5) {
            byte0 = 3;
        }
        EntityPainting entitypainting = new EntityPainting(world, i, j, k, byte0);
        if (entitypainting.func_410_i()) {
            world.entityJoinedWorld(entitypainting);
            itemstack.stackSize--;
        }
        return true;
    }
}

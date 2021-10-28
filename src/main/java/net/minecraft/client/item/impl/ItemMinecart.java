package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.mob.impl.EntityMinecart;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemMinecart extends Item {

    public int field_317_a;

    public ItemMinecart(int i, int j) {
        super(i);
        maxStackSize = 1;
        field_317_a = j;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        int i1 = world.getBlockId(i, j, k);
        if (i1 == Block.minecartTrack.blockID) {
            if (!world.multiplayerWorld) {
                world.entityJoinedWorld(new EntityMinecart(world, (float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, field_317_a));
            }
            itemstack.stackSize--;
            return true;
        } else {
            return false;
        }
    }
}

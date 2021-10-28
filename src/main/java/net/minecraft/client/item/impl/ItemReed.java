package net.minecraft.client.item.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.world.World;

public class ItemReed extends Item {

    private final int field_320_a;

    public ItemReed(int i, Block block) {
        super(i);
        field_320_a = block.blockID;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l) {
        if (world.getBlockId(i, j, k) == Block.snow.blockID) {
            l = 0;
        } else {
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
        }
        if (itemstack.stackSize == 0) {
            return false;
        }
        if (world.canBlockBePlacedAt(field_320_a, i, j, k, false)) {
            Block block = Block.blocksList[field_320_a];
            if (world.setBlockWithNotify(i, j, k, field_320_a)) {
                Block.blocksList[field_320_a].onBlockPlaced(world, i, j, k, l);
                world.playSoundEffect((float) i + 0.5F, (float) j + 0.5F, (float) k + 0.5F, block.stepSound.func_1145_d(), (block.stepSound.func_1147_b() + 1.0F) / 2.0F, block.stepSound.func_1144_c() * 0.8F);
                itemstack.stackSize--;
            }
        }
        return true;
    }
}

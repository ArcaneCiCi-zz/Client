package net.minecraft.client.blocks.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.world.World;

public class BlockWorkbench extends Block {

    public BlockWorkbench(int i) {
        super(i, Material.wood);
        blockIndexInTexture = 59;
    }

    public int getBlockTextureFromSide(int i) {
        if (i == 1) {
            return blockIndexInTexture - 16;
        }
        if (i == 0) {
            return Block.planks.getBlockTextureFromSide(0);
        }
        if (i == 2 || i == 4) {
            return blockIndexInTexture + 1;
        } else {
            return blockIndexInTexture;
        }
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
        entityplayer.displayWorkbenchGUI();
        return true;
    }
}

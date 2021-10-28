package me.arcanecici.client.command.impl;

import me.arcanecici.client.command.Command;
import me.arcanecici.client.util.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.item.impl.ItemStack;

/**
 * @author ArcaneCiCi ~ Best CheatBreaker Developer WorldWide <3
 */

public class GiveCommand extends Command {

    public GiveCommand() {
        super("give");
    }

    @Override
    public void execute(String cmdLabel, String[] args) {

        if (args.length != 2) {
            Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Usage: .give <item id> <amount>");
            return;
        }

        try {
            int id = Integer.parseInt(args[0]);
            int amount = Integer.parseInt(args[1]);
            Minecraft.getMinecraft().thePlayer.inventory.addItemStackToInventory(new ItemStack(id, amount));
            Minecraft.getMinecraft().ingameGUI.addChatMessage("Gave x" + amount + " of Item ID of " + id);
        } catch (NumberFormatException e) {
            Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Invalid arguments.");
            return;
        }

    }
}

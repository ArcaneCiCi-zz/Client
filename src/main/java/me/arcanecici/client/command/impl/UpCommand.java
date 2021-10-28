package me.arcanecici.client.command.impl;

import me.arcanecici.client.command.Command;
import me.arcanecici.client.util.ChatColor;
import net.minecraft.client.Minecraft;

/**
 * @author ArcaneCiCi
 */

public class UpCommand extends Command {

    public UpCommand() {
        super("up");
    }

    @Override
    public void execute(String cmdLabel, String[] args) {
        double y;

        if (args.length != 1) {
            Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Usage: .up <amount>");
            return;
        }

        try {
            y = Double.parseDouble(args[0]);
            Minecraft.getMinecraft().thePlayer.setPosition(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY + y, Minecraft.getMinecraft().thePlayer.posZ);
            Minecraft.getMinecraft().ingameGUI.addChatMessage("Teleporting...");
        } catch (NumberFormatException e) {
            Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Invalid arguments.");
            return;
        }
    }
}

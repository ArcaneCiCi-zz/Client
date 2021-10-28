package me.arcanecici.client.command.impl;

import me.arcanecici.client.command.Command;
import me.arcanecici.client.util.ChatColor;
import net.minecraft.client.Minecraft;

/**
 * @author ArcaneCiCi
 */

public class TpCommand extends Command {

    public TpCommand() {
        super("tp");
    }

    @Override
    public void execute(String cmdName, String[] args) {

        if (args.length != 3) {
            Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Usage: .tp <x, y, z>");
            return;
        }

        double x, y, z;
        try {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            z = Double.parseDouble(args[2]);
            Minecraft.getMinecraft().thePlayer.setPosition(x, y, z);
            Minecraft.getMinecraft().ingameGUI.addChatMessage("Teleporting...");
        } catch (NumberFormatException e) {
            Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Invalid arguments.");
            return;
        }
    }
}

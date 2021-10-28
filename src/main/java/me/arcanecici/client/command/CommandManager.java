package me.arcanecici.client.command;

import me.arcanecici.client.command.impl.DropCommand;
import me.arcanecici.client.command.impl.GiveCommand;
import me.arcanecici.client.command.impl.TpCommand;
import me.arcanecici.client.command.impl.UpCommand;
import me.arcanecici.client.util.ChatColor;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ArcaneCiCi
 */

public class CommandManager {
    private final List<Command> commands = new ArrayList<>();

    public CommandManager() {
        this.commands.add(new UpCommand());
        this.commands.add(new TpCommand());
        this.commands.add(new DropCommand());
        this.commands.add(new GiveCommand());
    }

    public void execute(String[] args) {
        String label = args[0].replace(".", "");

        for (Command command : this.commands) {
            if (command.getName().equalsIgnoreCase(label)) {
                command.execute(label, Arrays.copyOfRange(args, 1, args.length));
                return;
            }
        }

        Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Unknown command: \"." + label + "\"");
    }
}

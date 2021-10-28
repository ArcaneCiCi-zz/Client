package me.arcanecici.client.command;

import me.arcanecici.client.command.impl.DropCommand;
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
    public final UpCommand upCommand;
    public final TpCommand tpCommand;
    public final DropCommand dropCommand;
    private final List<Command> commands = new ArrayList<>();

    public CommandManager() {
        this.commands.add(this.upCommand = new UpCommand());
        this.commands.add(this.tpCommand = new TpCommand());
        this.commands.add(this.dropCommand = new DropCommand());
    }

    public void execute(String[] args) {
        String label = args[0].replace(".", "");

        this.commands.forEach(command -> {
            if (!command.getName().equalsIgnoreCase(label)) {
                Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatColor.RED + "Unknown command: \"." + label + "\"");
                return;
            }
            command.execute(label, Arrays.copyOfRange(args, 1, args.length));
        });
    }
}

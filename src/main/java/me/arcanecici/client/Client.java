package me.arcanecici.client;

import me.arcanecici.client.command.CommandManager;
import me.arcanecici.client.module.ModuleManager;
import lombok.Getter;

/**
 * @author ArcaneCiCi
 */

@Getter
public class Client {

    @Getter
    public static Client instance;
    public final ModuleManager modManager;
    private final CommandManager commandManager;

    public Client() {
        instance = this;

        commandManager = new CommandManager();
        System.out.println("[Client] Created Command Manager");

        modManager = new ModuleManager();
        System.out.println("[Client] Created Mod Manager");
    }
}

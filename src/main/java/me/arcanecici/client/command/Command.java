package me.arcanecici.client.command;

import lombok.Data;

/**
 * @author ArcaneCiCi
 */

@Data
public abstract class Command {
    private final String name;

    public void execute(String cmdName, String[] args) {
    }
}

package me.arcanecici.client.module.impl;

import me.arcanecici.client.module.Module;

import java.awt.*;

/**
 * @author ArcaneCiCi
 */

public class FullbrightModule extends Module {

    public FullbrightModule() {
        super("Fullbright", true);
        this.setColor(Color.YELLOW.getRGB());
    }


    @Override
    public void onEnable() {
        mc.gameSettings.setOptionValue(9, 1);
    }

    @Override
    public void onDisable() {
        mc.gameSettings.setOptionValue(9, 1);
    }
}

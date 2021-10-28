package me.arcanecici.client.module.impl;

import me.arcanecici.client.module.Module;
import org.lwjgl.input.Keyboard;

/**
 * @author ArcaneCiCi
 */
public class FlyModule extends Module {

    public FlyModule() {
        super("Flight", false);
        this.setColor(43520);
    }

    @Override
    public void update() {
        mc.thePlayer.fallDistance = 0.0F;

        if (this.isEnabled()) {
            if (mc.currentScreen == null) {
                if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
                    mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.05D, mc.thePlayer.posZ);
                }
                if (Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.keyCode)) {
                    mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY - 0.05D, mc.thePlayer.posZ);
                }
            }
        }
    }
}

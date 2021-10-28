package me.arcanecici.client.module;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;

/**
 * @author ArcaneCiCi
 */

@Getter
@Setter
public abstract class Module {

    public Minecraft mc;

    private String name;

    private int color;

    private boolean enabled;

    public Module(String name, boolean defaultState) {
        this.mc = Minecraft.getMinecraft();
        this.name = name;
        this.enabled = defaultState;
        this.setup();
    }

    public void toggle() {
        this.enabled = !this.enabled;

        if (this.enabled) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void setup() {
    }

    public void update() {
    }

}

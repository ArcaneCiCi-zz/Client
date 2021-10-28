package me.arcanecici.client.module;

import me.arcanecici.client.module.impl.*;
import lombok.Getter;
import me.arcanecici.client.module.impl.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ArcaneCiCi
 */

@Getter
public class ModuleManager {
    public List<Module> mods = new CopyOnWriteArrayList<>();

    public FullbrightModule fullbrightModule;
    public XrayModule xrayModule;
    public TimerModule timerModule;
    public FlyModule flyModule;
    public InstantModule instantModule;

    public ModuleManager() {
        this.mods.add(this.fullbrightModule = new FullbrightModule());
        this.mods.add(this.xrayModule = new XrayModule());
        this.mods.add(this.timerModule = new TimerModule());
        this.mods.add(this.flyModule = new FlyModule());
        this.mods.add(this.instantModule = new InstantModule());
    }
}

package me.arcanecici.client.module.impl;

import me.arcanecici.client.module.Module;
import lombok.Setter;
import net.minecraft.client.blocks.Block;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ArcaneCiCi
 */

@Setter
public class XrayModule extends Module {

    public int currentXrayType = 0;
    public int xrayTypeCache = currentXrayType;

    public Map<Integer, String> displayTypes = new HashMap<>();
    public Map<Integer, Block> blockTypes = new HashMap<>();

    public XrayModule() {
        super("Xray", false);
        this.displayTypes.put(1, "Diamond");
        this.displayTypes.put(2, "Gold");
        this.displayTypes.put(3, "Iron");
        this.displayTypes.put(4, "Redstone");
        this.displayTypes.put(5, "Coal");
        this.displayTypes.put(6, "Chest");

        this.blockTypes.put(1, Block.oreDiamond);
        this.blockTypes.put(2, Block.oreGold);
        this.blockTypes.put(3, Block.oreIron);
        this.blockTypes.put(4, Block.oreRedstone);
        this.blockTypes.put(5, Block.oreCoal);
        this.blockTypes.put(6, Block.chest);
        this.setColor(Color.MAGENTA.getRGB());
    }

    @Override
    public void onEnable() {
        this.setCurrentXrayType(xrayTypeCache);
        if (this.xrayTypeCache == 0) this.setCurrentXrayType(0);
        this.mc.gameSettings.setOptionValue(9, 1);
    }

    @Override
    public void onDisable() {
        this.mc.gameSettings.setOptionValue(9, 1);
        this.setCurrentXrayType(0);
    }

    @Override
    public void setup() {
    }

    public void updateCache() {
        this.xrayTypeCache = this.currentXrayType;
    }
}

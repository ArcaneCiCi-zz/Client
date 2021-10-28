package net.minecraft.client.entity.mob.impl;

import net.minecraft.client.world.World;

public class EntitySplashFX extends EntityRainFX {

    public EntitySplashFX(World world, double d, double d1, double d2,
                          double d3, double d4, double d5) {
        super(world, d, d1, d2);
        field_664_h = 0.04F;
        field_670_b++;
        if (d4 == 0.0D && (d3 != 0.0D || d5 != 0.0D)) {
            motionX = d3;
            motionY = d4 + 0.10000000000000001D;
            motionZ = d5;
        }
    }
}

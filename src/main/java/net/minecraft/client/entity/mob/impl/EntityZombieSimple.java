package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.world.World;

public class EntityZombieSimple extends EntityMobs {

    public EntityZombieSimple(World world) {
        super(world);
        texture = "/mob/zombie.png";
        field_9333_am = 0.5F;
        field_762_e = 50;
        health *= 10;
        yOffset *= 6F;
        setSize(width * 6F, height * 6F);
    }

    protected float func_439_a(int i, int j, int k) {
        return worldObj.getLightBrightness(i, j, k) - 0.5F;
    }
}

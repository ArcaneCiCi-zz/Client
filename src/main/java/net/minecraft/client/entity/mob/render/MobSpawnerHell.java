package net.minecraft.client.entity.mob.render;


import net.minecraft.client.entity.mob.impl.EntityGhast;
import net.minecraft.client.entity.mob.impl.EntityPigZombie;

public class MobSpawnerHell extends MobSpawnerBase {

    public MobSpawnerHell() {
        biomeMonsters = (new Class[]{
                EntityGhast.class, EntityPigZombie.class
        });
        biomeCreatures = new Class[0];
    }
}

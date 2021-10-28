package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.world.impl.WorldRenderer;

import java.util.Comparator;

public class EntitySorter
        implements Comparator {

    private final Entity field_1594_a;

    public EntitySorter(Entity entity) {
        field_1594_a = entity;
    }

    public int func_1063_a(WorldRenderer worldrenderer, WorldRenderer worldrenderer1) {
        return worldrenderer.func_1202_a(field_1594_a) >= worldrenderer1.func_1202_a(field_1594_a) ? 1 : -1;
    }

    public int compare(Object obj, Object obj1) {
        return func_1063_a((WorldRenderer) obj, (WorldRenderer) obj1);
    }
}

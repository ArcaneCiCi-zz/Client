package net.minecraft.client.entity.mob.render;


import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.entity.mob.impl.EntitySheep;
import net.minecraft.client.entity.render.RenderLiving;
import net.minecraft.client.model.ModelBase;

public class RenderSheep extends RenderLiving {

    public RenderSheep(ModelBase modelbase, ModelBase modelbase1, float f) {
        super(modelbase, f);
        func_4013_a(modelbase1);
    }

    protected boolean func_176_a(EntitySheep entitysheep, int i) {
        loadTexture("/mob/sheep_fur.png");
        return i == 0 && !entitysheep.sheared;
    }

    protected boolean func_166_a(EntityLiving entityliving, int i) {
        return func_176_a((EntitySheep) entityliving, i);
    }
}

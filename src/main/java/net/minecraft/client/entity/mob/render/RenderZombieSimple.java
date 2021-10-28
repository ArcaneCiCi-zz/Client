package net.minecraft.client.entity.mob.render;


import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.entity.mob.impl.EntityZombieSimple;
import net.minecraft.client.entity.render.RenderLiving;
import net.minecraft.client.model.ModelBase;
import org.lwjgl.opengl.GL11;

public class RenderZombieSimple extends RenderLiving {

    private final float field_204_f;

    public RenderZombieSimple(ModelBase modelbase, float f, float f1) {
        super(modelbase, f * f1);
        field_204_f = f1;
    }

    protected void func_175_a(EntityZombieSimple entityzombiesimple, float f) {
        GL11.glScalef(field_204_f, field_204_f, field_204_f);
    }

    protected void func_6330_a(EntityLiving entityliving, float f) {
        func_175_a((EntityZombieSimple) entityliving, f);
    }
}

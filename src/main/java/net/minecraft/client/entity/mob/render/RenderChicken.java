package net.minecraft.client.entity.mob.render;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.entity.mob.impl.EntityChicken;
import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.entity.render.RenderLiving;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.model.ModelBase;

public class RenderChicken extends RenderLiving {

    public RenderChicken(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    public void func_181_a(EntityChicken entitychicken, double d, double d1, double d2,
                           float f, float f1) {
        super.func_171_a(entitychicken, d, d1, d2, f, f1);
    }

    protected float func_182_a(EntityChicken entitychicken, float f) {
        float f1 = entitychicken.field_756_e + (entitychicken.field_752_b - entitychicken.field_756_e) * f;
        float f2 = entitychicken.field_757_d + (entitychicken.field_758_c - entitychicken.field_757_d) * f;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    protected float func_170_d(EntityLiving entityliving, float f) {
        return func_182_a((EntityChicken) entityliving, f);
    }

    public void func_171_a(EntityLiving entityliving, double d, double d1, double d2,
                           float f, float f1) {
        func_181_a((EntityChicken) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        func_181_a((EntityChicken) entity, d, d1, d2, f, f1);
    }
}

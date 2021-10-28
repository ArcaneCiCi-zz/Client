package net.minecraft.client.entity.mob.render;


import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.entity.mob.impl.EntityPig;
import net.minecraft.client.entity.render.RenderLiving;
import net.minecraft.client.model.ModelBase;

public class RenderPig extends RenderLiving {

    public RenderPig(ModelBase modelbase, ModelBase modelbase1, float f) {
        super(modelbase, f);
        func_4013_a(modelbase1);
    }

    protected boolean func_180_a(EntityPig entitypig, int i) {
        loadTexture("/mob/saddle.png");
        return i == 0 && entitypig.rideable;
    }

    protected boolean func_166_a(EntityLiving entityliving, int i) {
        return func_180_a((EntityPig) entityliving, i);
    }
}

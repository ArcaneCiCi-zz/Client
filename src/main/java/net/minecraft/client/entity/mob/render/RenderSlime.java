package net.minecraft.client.entity.mob.render;


import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.entity.mob.impl.EntitySlime;
import net.minecraft.client.entity.render.RenderLiving;
import net.minecraft.client.model.ModelBase;
import org.lwjgl.opengl.GL11;

public class RenderSlime extends RenderLiving {

    private final ModelBase field_205_f;

    public RenderSlime(ModelBase modelbase, ModelBase modelbase1, float f) {
        super(modelbase, f);
        field_205_f = modelbase1;
    }

    protected boolean func_179_a(EntitySlime entityslime, int i) {
        if (i == 0) {
            func_4013_a(field_205_f);
            GL11.glEnable(2977 /*GL_NORMALIZE*/);
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glBlendFunc(770, 771);
            return true;
        }
        if (i == 1) {
            GL11.glDisable(3042 /*GL_BLEND*/);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
        return false;
    }

    protected void func_178_a(EntitySlime entityslime, float f) {
        float f1 = (entityslime.field_767_b + (entityslime.field_768_a - entityslime.field_767_b) * f) / ((float) entityslime.field_770_c * 0.5F + 1.0F);
        float f2 = 1.0F / (f1 + 1.0F);
        float f3 = entityslime.field_770_c;
        GL11.glScalef(f2 * f3, (1.0F / f2) * f3, f2 * f3);
    }

    protected void func_6330_a(EntityLiving entityliving, float f) {
        func_178_a((EntitySlime) entityliving, f);
    }

    protected boolean func_166_a(EntityLiving entityliving, int i) {
        return func_179_a((EntitySlime) entityliving, i);
    }
}

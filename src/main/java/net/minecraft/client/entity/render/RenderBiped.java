package net.minecraft.client.entity.render;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.entity.mob.model.impl.ModelBiped;
import net.minecraft.client.blocks.render.RenderBlocks;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.impl.ItemStack;
import org.lwjgl.opengl.GL11;

public class RenderBiped extends RenderLiving {

    protected ModelBiped field_4013_a;

    public RenderBiped(ModelBiped modelbiped, float f) {
        super(modelbiped, f);
        field_4013_a = modelbiped;
    }

    protected void func_6331_b(EntityLiving entityliving, float f) {
        ItemStack itemstack = entityliving.getHeldItem();
        if (itemstack != null) {
            GL11.glPushMatrix();
            field_4013_a.bipedRightArm.func_926_b(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if (itemstack.itemID < 256 && RenderBlocks.func_1219_a(Block.blocksList[itemstack.itemID].getRenderType())) {
                float f1 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f1 *= 0.75F;
                GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
            } else if (Item.itemsList[itemstack.itemID].isFull3D()) {
                float f2 = 0.625F;
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else {
                float f3 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f3, f3, f3);
                GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
            }
            renderManager.field_4236_f.renderItem(itemstack);
            GL11.glPopMatrix();
        }
    }
}

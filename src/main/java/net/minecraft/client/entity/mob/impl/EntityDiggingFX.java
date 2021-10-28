package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.render.impl.Tessellator;
import net.minecraft.client.world.World;

public class EntityDiggingFX extends EntityFX {

    private final Block field_4082_a;

    public EntityDiggingFX(World world, double d, double d1, double d2,
                           double d3, double d4, double d5, Block block) {
        super(world, d, d1, d2, d3, d4, d5);
        field_4082_a = block;
        field_670_b = block.blockIndexInTexture;
        field_664_h = block.field_357_bm;
        field_663_i = field_662_j = field_661_k = 0.6F;
        particleSize /= 2.0F;
    }

    public EntityDiggingFX func_4041_a(int i, int j, int k) {
        if (field_4082_a != Block.grass) {
            int l = field_4082_a.colorMultiplier(worldObj, i, j, k);
            field_663_i *= (float) (l >> 16 & 0xff) / 255F;
            field_662_j *= (float) (l >> 8 & 0xff) / 255F;
            field_661_k *= (float) (l & 0xff) / 255F;
        }
        return this;
    }

    public int func_404_c() {
        return 1;
    }

    public void func_406_a(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5) {
        float f6 = ((float) (field_670_b % 16) + field_669_c / 4F) / 16F;
        float f7 = f6 + 0.01560938F;
        float f8 = ((float) (field_670_b / 16) + field_668_d / 4F) / 16F;
        float f9 = f8 + 0.01560938F;
        float f10 = 0.1F * particleSize;
        float f11 = (float) ((prevPosX + (posX - prevPosX) * (double) f) - field_660_l);
        float f12 = (float) ((prevPosY + (posY - prevPosY) * (double) f) - field_659_m);
        float f13 = (float) ((prevPosZ + (posZ - prevPosZ) * (double) f) - field_658_n);
        float f14 = getEntityBrightness(f);
        tessellator.setColorOpaque_F(f14 * field_663_i, f14 * field_662_j, f14 * field_661_k);
        tessellator.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f6, f9);
        tessellator.addVertexWithUV((f11 - f1 * f10) + f4 * f10, f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f6, f8);
        tessellator.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f7, f8);
        tessellator.addVertexWithUV((f11 + f1 * f10) - f4 * f10, f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f7, f9);
    }
}

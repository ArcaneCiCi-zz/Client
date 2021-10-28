package net.minecraft.client.entity.mob.model.impl;


import net.minecraft.client.entity.mob.model.ModelRenderer;

public class ModelSheep2 extends ModelQuadraped {

    public ModelSheep2() {
        super(12, 0.0F);
        head = new ModelRenderer(0, 0);
        head.addBox(-3F, -4F, -6F, 6, 6, 8, 0.0F);
        head.setPosition(0.0F, 6F, -8F);
        body = new ModelRenderer(28, 8);
        body.addBox(-4F, -10F, -7F, 8, 16, 6, 0.0F);
        body.setPosition(0.0F, 5F, 2.0F);
    }
}

package net.minecraft.client.misc;


import net.minecraft.client.entity.mob.model.ModelRenderer;

public class SignModel {

    public ModelRenderer field_1346_a;
    public ModelRenderer field_1345_b;

    public SignModel() {
        field_1346_a = new ModelRenderer(0, 0);
        field_1346_a.addBox(-12F, -14F, -1F, 24, 12, 2, 0.0F);
        field_1345_b = new ModelRenderer(0, 14);
        field_1345_b.addBox(-1F, -2F, -1F, 2, 14, 2, 0.0F);
    }

    public void func_887_a() {
        field_1346_a.render(0.0625F);
        field_1345_b.render(0.0625F);
    }
}

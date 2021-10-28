package net.minecraft.client.entity.mob.model.impl;


import net.minecraft.client.entity.mob.model.ModelRenderer;

public class ModelSkeleton extends ModelZombie {

    public ModelSkeleton() {
        float f = 0.0F;
        bipedRightArm = new ModelRenderer(40, 16);
        bipedRightArm.addBox(-1F, -2F, -1F, 2, 12, 2, f);
        bipedRightArm.setPosition(-5F, 2.0F, 0.0F);
        bipedLeftArm = new ModelRenderer(40, 16);
        bipedLeftArm.mirror = true;
        bipedLeftArm.addBox(-1F, -2F, -1F, 2, 12, 2, f);
        bipedLeftArm.setPosition(5F, 2.0F, 0.0F);
        bipedRightLeg = new ModelRenderer(0, 16);
        bipedRightLeg.addBox(-1F, 0.0F, -1F, 2, 12, 2, f);
        bipedRightLeg.setPosition(-2F, 12F, 0.0F);
        bipedLeftLeg = new ModelRenderer(0, 16);
        bipedLeftLeg.mirror = true;
        bipedLeftLeg.addBox(-1F, 0.0F, -1F, 2, 12, 2, f);
        bipedLeftLeg.setPosition(2.0F, 12F, 0.0F);
    }
}

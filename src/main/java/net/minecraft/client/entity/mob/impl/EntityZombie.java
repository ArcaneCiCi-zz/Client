package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.item.Item;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.world.World;

public class EntityZombie extends EntityMobs {

    public EntityZombie(World world) {
        super(world);
        texture = "/mob/zombie.png";
        field_9333_am = 0.5F;
        field_762_e = 5;
    }

    public void onLivingUpdate() {
        if (worldObj.isDaytime()) {
            float f = getEntityBrightness(1.0F);
            if (f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F) {
                fire = 300;
            }
        }
        super.onLivingUpdate();
    }

    protected String getLivingSound() {
        return "mob.zombie";
    }

    protected String getHurtSound() {
        return "mob.zombiehurt";
    }

    protected String getDeathSound() {
        return "mob.zombiedeath";
    }

    protected int getDropItemId() {
        return Item.feather.shiftedIndex;
    }
}

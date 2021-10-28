package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.nbt.NBTTagCompound;
import net.minecraft.client.world.World;

public class EntitySkeleton extends EntityMobs {

    private static final ItemStack defaultHeldItem;

    static {
        defaultHeldItem = new ItemStack(Item.bow, 1);
    }

    public EntitySkeleton(World world) {
        super(world);
        texture = "/mob/skeleton.png";
    }

    protected String getLivingSound() {
        return "mob.skeleton";
    }

    protected String getHurtSound() {
        return "mob.skeletonhurt";
    }

    protected String getDeathSound() {
        return "mob.skeletonhurt";
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

    protected void attackEntity(Entity entity, float f) {
        if (f < 10F) {
            double d = entity.posX - posX;
            double d1 = entity.posZ - posZ;
            if (attackTime == 0) {
                EntityArrow entityarrow = new EntityArrow(worldObj, this);
                entityarrow.posY += 1.3999999761581421D;
                double d2 = entity.posY - 0.20000000298023224D - entityarrow.posY;
                float f1 = MathHelper.sqrt_double(d * d + d1 * d1) * 0.2F;
                worldObj.playSoundAtEntity(this, "random.bow", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
                worldObj.entityJoinedWorld(entityarrow);
                entityarrow.func_408_a(d, d2 + (double) f1, d1, 0.6F, 12F);
                attackTime = 30;
            }
            rotationYaw = (float) ((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
            hasAttacked = true;
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected int getDropItemId() {
        return Item.arrow.shiftedIndex;
    }

    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }
}

package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.nbt.NBTTagCompound;
import net.minecraft.client.world.World;

public class EntityCow extends EntityAnimals {

    public boolean unusedBoolean;

    public EntityCow(World world) {
        super(world);
        unusedBoolean = false;
        texture = "/mob/cow.png";
        setSize(0.9F, 1.3F);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected String getLivingSound() {
        return "mob.cow";
    }

    protected String getHurtSound() {
        return "mob.cowhurt";
    }

    protected String getDeathSound() {
        return "mob.cowhurt";
    }

    protected float getSoundVolume() {
        return 0.4F;
    }

    protected int getDropItemId() {
        return Item.leather.shiftedIndex;
    }

    public boolean interact(EntityPlayer entityplayer) {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if (itemstack != null && itemstack.itemID == Item.bucketEmpty.shiftedIndex) {
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, new ItemStack(Item.bucketMilk));
            return true;
        } else {
            return false;
        }
    }
}

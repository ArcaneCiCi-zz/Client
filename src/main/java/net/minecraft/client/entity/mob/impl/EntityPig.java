package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.entity.player.EntityPlayer;
import net.minecraft.client.item.Item;
import net.minecraft.client.nbt.NBTTagCompound;
import net.minecraft.client.world.World;

public class EntityPig extends EntityAnimals {

    public boolean rideable;

    public EntityPig(World world) {
        super(world);
        rideable = false;
        texture = "/mob/pig.png";
        setSize(0.9F, 0.9F);
        rideable = false;
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Saddle", rideable);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        rideable = nbttagcompound.getBoolean("Saddle");
    }

    protected String getLivingSound() {
        return "mob.pig";
    }

    protected String getHurtSound() {
        return "mob.pig";
    }

    protected String getDeathSound() {
        return "mob.pigdeath";
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (rideable) {
            entityplayer.mountEntity(this);
            return true;
        } else {
            return false;
        }
    }

    protected int getDropItemId() {
        return Item.porkRaw.shiftedIndex;
    }
}

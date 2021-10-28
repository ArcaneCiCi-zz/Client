package net.minecraft.client.entity.player;

/**
 * @author ArcaneCiCi
 */

import net.minecraft.client.nbt.NBTTagCompound;

public class PlayerCapabilities {
    public boolean isFlying;
    public boolean allowFlying;

    private float flySpeed = 0.05F;

    public void writeCapabilitiesToNBT(NBTTagCompound tagCompound) {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setBoolean("flying", this.isFlying);
        nbttagcompound.setBoolean("mayfly", this.allowFlying);
        nbttagcompound.setFloat("flySpeed", this.flySpeed);
        tagCompound.setTag("abilities", nbttagcompound);
    }

    public void readCapabilitiesFromNBT(NBTTagCompound tagCompound)
    {
        if (tagCompound.hasKey("abilities")) {
            NBTTagCompound nbttagcompound = tagCompound.getCompoundTag("abilities");
            this.isFlying = nbttagcompound.getBoolean("flying");
            this.allowFlying = nbttagcompound.getBoolean("mayfly");

            if (nbttagcompound.hasKey("flySpeed")) {
                this.flySpeed = nbttagcompound.getFloat("flySpeed");
            }
        }
    }

    public float getFlySpeed()
    {
        return this.flySpeed;
    }

    public void setFlySpeed(float speed)
    {
        this.flySpeed = speed;
    }

}


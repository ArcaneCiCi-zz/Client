package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.enums.EnumArt;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.item.material.Material;
import net.minecraft.client.misc.MathHelper;
import net.minecraft.client.nbt.NBTTagCompound;
import net.minecraft.client.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityPainting extends Entity {

    public int field_691_a;
    public EnumArt field_690_b;
    private int field_695_c;
    private int field_9322_d;
    private int field_9321_e;
    private int field_9320_f;

    public EntityPainting(World world) {
        super(world);
        field_695_c = 0;
        field_691_a = 0;
        yOffset = 0.0F;
        setSize(0.5F, 0.5F);
    }

    public EntityPainting(World world, int i, int j, int k, int l) {
        this(world);
        field_9322_d = i;
        field_9321_e = j;
        field_9320_f = k;
        ArrayList arraylist = new ArrayList<>();
        EnumArt[] aenumart = EnumArt.values();
        int i1 = aenumart.length;
        for (int j1 = 0; j1 < i1; j1++) {
            EnumArt enumart = aenumart[j1];
            field_690_b = enumart;
            func_412_b(l);
            if (func_410_i()) {
                arraylist.add(enumart);
            }
        }

        if (arraylist.size() > 0) {
            field_690_b = (EnumArt) arraylist.get(rand.nextInt(arraylist.size()));
        }
        func_412_b(l);
    }

    public void func_412_b(int i) {
        field_691_a = i;
        prevRotationYaw = rotationYaw = i * 90;
        float f = field_690_b.field_1623_z;
        float f1 = field_690_b.field_1636_A;
        float f2 = field_690_b.field_1623_z;
        if (i == 0 || i == 2) {
            f2 = 0.5F;
        } else {
            f = 0.5F;
        }
        f /= 32F;
        f1 /= 32F;
        f2 /= 32F;
        float f3 = (float) field_9322_d + 0.5F;
        float f4 = (float) field_9321_e + 0.5F;
        float f5 = (float) field_9320_f + 0.5F;
        float f6 = 0.5625F;
        if (i == 0) {
            f5 -= f6;
        }
        if (i == 1) {
            f3 -= f6;
        }
        if (i == 2) {
            f5 += f6;
        }
        if (i == 3) {
            f3 += f6;
        }
        if (i == 0) {
            f3 -= func_411_c(field_690_b.field_1623_z);
        }
        if (i == 1) {
            f5 += func_411_c(field_690_b.field_1623_z);
        }
        if (i == 2) {
            f3 += func_411_c(field_690_b.field_1623_z);
        }
        if (i == 3) {
            f5 -= func_411_c(field_690_b.field_1623_z);
        }
        f4 += func_411_c(field_690_b.field_1636_A);
        setPosition(f3, f4, f5);
        float f7 = -0.00625F;
        boundingBox.setBounds(f3 - f - f7, f4 - f1 - f7, f5 - f2 - f7, f3 + f + f7, f4 + f1 + f7, f5 + f2 + f7);
    }

    private float func_411_c(int i) {
        if (i == 32) {
            return 0.5F;
        }
        return i != 64 ? 0.0F : 0.5F;
    }

    public void onUpdate() {
        if (field_695_c++ == 100 && !func_410_i()) {
            field_695_c = 0;
            setEntityDead();
            worldObj.entityJoinedWorld(new EntityItem(worldObj, posX, posY, posZ, new ItemStack(Item.painting)));
        }
    }

    public boolean func_410_i() {
        if (worldObj.getCollidingBoundingBoxes(this, boundingBox).size() > 0) {
            return false;
        }
        int i = field_690_b.field_1623_z / 16;
        int j = field_690_b.field_1636_A / 16;
        int k = field_9322_d;
        int l = field_9321_e;
        int i1 = field_9320_f;
        if (field_691_a == 0) {
            k = MathHelper.floor_double(posX - (double) ((float) field_690_b.field_1623_z / 32F));
        }
        if (field_691_a == 1) {
            i1 = MathHelper.floor_double(posZ - (double) ((float) field_690_b.field_1623_z / 32F));
        }
        if (field_691_a == 2) {
            k = MathHelper.floor_double(posX - (double) ((float) field_690_b.field_1623_z / 32F));
        }
        if (field_691_a == 3) {
            i1 = MathHelper.floor_double(posZ - (double) ((float) field_690_b.field_1623_z / 32F));
        }
        l = MathHelper.floor_double(posY - (double) ((float) field_690_b.field_1636_A / 32F));
        for (int j1 = 0; j1 < i; j1++) {
            for (int k1 = 0; k1 < j; k1++) {
                Material material;
                if (field_691_a == 0 || field_691_a == 2) {
                    material = worldObj.getBlockMaterial(k + j1, l + k1, field_9320_f);
                } else {
                    material = worldObj.getBlockMaterial(field_9322_d, l + k1, i1 + j1);
                }
                if (!material.func_878_a()) {
                    return false;
                }
            }

        }

        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox);
        for (int l1 = 0; l1 < list.size(); l1++) {
            if (list.get(l1) instanceof EntityPainting) {
                return false;
            }
        }

        return true;
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean canAttackEntity(Entity entity, int i) {
        setEntityDead();
        func_9281_M();
        worldObj.entityJoinedWorld(new EntityItem(worldObj, posX, posY, posZ, new ItemStack(Item.painting)));
        return true;
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setByte("Dir", (byte) field_691_a);
        nbttagcompound.setString("Motive", field_690_b.field_1624_y);
        nbttagcompound.setInteger("TileX", field_9322_d);
        nbttagcompound.setInteger("TileY", field_9321_e);
        nbttagcompound.setInteger("TileZ", field_9320_f);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        field_691_a = nbttagcompound.getByte("Dir");
        field_9322_d = nbttagcompound.getInteger("TileX");
        field_9321_e = nbttagcompound.getInteger("TileY");
        field_9320_f = nbttagcompound.getInteger("TileZ");
        String s = nbttagcompound.getString("Motive");
        EnumArt[] aenumart = EnumArt.values();
        int i = aenumart.length;
        for (int j = 0; j < i; j++) {
            EnumArt enumart = aenumart[j];
            if (enumart.field_1624_y.equals(s)) {
                field_690_b = enumart;
            }
        }

        if (field_690_b == null) {
            field_690_b = EnumArt.Kebab;
        }
        func_412_b(field_691_a);
    }
}

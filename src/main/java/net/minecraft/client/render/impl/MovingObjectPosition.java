package net.minecraft.client.render.impl;


import net.minecraft.client.entity.Entity;

public class MovingObjectPosition {

    public int typeOfHit;
    public int blockX;
    public int blockY;
    public int blockZ;
    public int sideHit;
    public Vec3D hitVec;
    public Entity entityHit;
    public MovingObjectPosition(int i, int j, int k, int l, Vec3D vec3d) {
        typeOfHit = 0;
        blockX = i;
        blockY = j;
        blockZ = k;
        sideHit = l;
        hitVec = Vec3D.createVector(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord);
    }
    public MovingObjectPosition(Entity entity) {
        typeOfHit = 1;
        entityHit = entity;
        hitVec = Vec3D.createVector(entity.posX, entity.posY, entity.posZ);
    }
}

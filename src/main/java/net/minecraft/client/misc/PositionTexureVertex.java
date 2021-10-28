package net.minecraft.client.misc;


import net.minecraft.client.render.impl.Vec3D;

public class PositionTexureVertex {

    public Vec3D vector3D;
    public float texturePositionX;
    public float texturePositionY;

    public PositionTexureVertex(float f, float f1, float f2, float f3, float f4) {
        this(Vec3D.createVectorHelper(f, f1, f2), f3, f4);
    }

    public PositionTexureVertex(PositionTexureVertex positiontexurevertex, float f, float f1) {
        vector3D = positiontexurevertex.vector3D;
        texturePositionX = f;
        texturePositionY = f1;
    }
    public PositionTexureVertex(Vec3D vec3d, float f, float f1) {
        vector3D = vec3d;
        texturePositionX = f;
        texturePositionY = f1;
    }

    public PositionTexureVertex setTexturePosition(float f, float f1) {
        return new PositionTexureVertex(this, f, f1);
    }
}

package net.minecraft.client.misc;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.render.impl.Vec3D;

public class PathEntity {

    public final int pathLength;
    private final PathPoint[] points;
    private int pathIndex;

    public PathEntity(PathPoint[] apathpoint) {
        points = apathpoint;
        pathLength = apathpoint.length;
    }

    public void incrementPathIndex() {
        pathIndex++;
    }

    public boolean isFinished() {
        return pathIndex >= points.length;
    }

    public Vec3D getPosition(Entity entity) {
        double d = (double) points[pathIndex].xCoord + (double) (int) (entity.width + 1.0F) * 0.5D;
        double d1 = points[pathIndex].yCoord;
        double d2 = (double) points[pathIndex].zCoord + (double) (int) (entity.width + 1.0F) * 0.5D;
        return Vec3D.createVector(d, d1, d2);
    }
}

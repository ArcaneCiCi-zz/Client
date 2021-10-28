package net.minecraft.client.interfaces;

import net.minecraft.client.entity.Entity;
import net.minecraft.client.world.tile.TileEntity;

public interface IWorldAccess {

    void func_934_a(int i, int j, int k);

    void func_937_b(int i, int j, int k, int l, int i1, int j1);

    void playSound(String s, double d, double d1, double d2, float f, float f1);

    void spawnParticle(String s, double d, double d1, double d2, double d3, double d4, double d5);

    void obtainEntitySkin(Entity entity);

    void releaseEntitySkin(Entity entity);

    void func_936_e();

    void playRecord(String s, int i, int j, int k);

    void func_935_a(int i, int j, int k, TileEntity tileentity);
}

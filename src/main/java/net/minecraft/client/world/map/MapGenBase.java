package net.minecraft.client.world.map;


import net.minecraft.client.world.World;
import net.minecraft.client.world.chunk.IChunkProvider;

import java.util.Random;

public class MapGenBase {

    protected int field_1306_a;
    protected Random field_1305_b;

    public MapGenBase() {
        field_1306_a = 8;
        field_1305_b = new Random();
    }

    public void func_867_a(IChunkProvider ichunkprovider, World world, int i, int j, byte[] abyte0) {
        int k = field_1306_a;
        field_1305_b.setSeed(world.randomSeed);
        long l = (field_1305_b.nextLong() / 2L) * 2L + 1L;
        long l1 = (field_1305_b.nextLong() / 2L) * 2L + 1L;
        for (int i1 = i - k; i1 <= i + k; i1++) {
            for (int j1 = j - k; j1 <= j + k; j1++) {
                field_1305_b.setSeed((long) i1 * l + (long) j1 * l1 ^ world.randomSeed);
                func_868_a(world, i1, j1, i, j, abyte0);
            }

        }

    }

    protected void func_868_a(World world, int i, int j, int k, int l, byte[] abyte0) {
    }
}

package net.minecraft.client.render.impl;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ColorizerGrass {

    private static final int[] field_6540_a;

    static {
        field_6540_a = new int[0x10000];
        try {
            BufferedImage bufferedimage = ImageIO.read((ColorizerFoliage.class).getResource("/misc/grasscolor.png"));
            bufferedimage.getRGB(0, 0, 256, 256, field_6540_a, 0, 256);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public ColorizerGrass() {
    }

    public static int func_4147_a(double d, double d1) {
        d1 *= d;
        int i = (int) ((1.0D - d) * 255D);
        int j = (int) ((1.0D - d1) * 255D);
        return field_6540_a[j << 8 | i];
    }

    static Class _mthclass$(String s) {
        try {
            return Class.forName(s);
        } catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}

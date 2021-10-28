package net.minecraft.client.misc;


import net.minecraft.client.interfaces.ICamera;
import net.minecraft.client.render.impl.AxisAlignedBB;
import net.minecraft.client.render.impl.ClippingHelper;
import net.minecraft.client.render.impl.ClippingHelperImplementation;

public class Frustrum implements ICamera {

    private final ClippingHelper field_593_a;
    private double field_592_b;
    private double field_595_c;
    private double field_594_d;

    public Frustrum() {
        field_593_a = ClippingHelperImplementation.func_1155_a();
    }

    public void func_343_a(double d, double d1, double d2) {
        field_592_b = d;
        field_595_c = d1;
        field_594_d = d2;
    }

    public boolean func_344_a(double d, double d1, double d2, double d3, double d4, double d5) {
        return field_593_a.func_1152_a(d - field_592_b, d1 - field_595_c, d2 - field_594_d, d3 - field_592_b, d4 - field_595_c, d5 - field_594_d);
    }

    public boolean func_342_a(AxisAlignedBB axisalignedbb) {
        return func_344_a(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
    }
}

package net.minecraft.client.enums.helper;

import net.minecraft.client.enums.EnumOS2;

public class EnumOSMappingHelper {

    public static final int[] enumInteger;

    static {
        enumInteger = new int[EnumOS2.values().length];
        try {
            enumInteger[EnumOS2.linux.ordinal()] = 1;
        } catch (NoSuchFieldError ignored) {
        }
        try {
            enumInteger[EnumOS2.solaris.ordinal()] = 2;
        } catch (NoSuchFieldError ignored) {
        }
        try {
            enumInteger[EnumOS2.windows.ordinal()] = 3;
        } catch (NoSuchFieldError ignored) {
        }
        try {
            enumInteger[EnumOS2.macos.ordinal()] = 4;
        } catch (NoSuchFieldError ignored) {
        }
    }
}

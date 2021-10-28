package net.minecraft.client.item.impl;


import net.minecraft.client.item.Item;

public class ItemArmor extends Item {

    private static final int[] damageReduceAmmountArray = {
            3, 8, 6, 3
    };
    private static final int[] maxDamageArray = {
            11, 16, 15, 13
    };
    public final int armorLevel;
    public final int armorType;
    public final int damageReduceAmmount;
    public final int renderIndex;
    public ItemArmor(int i, int j, int k, int l) {
        super(i);
        armorLevel = j;
        armorType = l;
        renderIndex = k;
        damageReduceAmmount = damageReduceAmmountArray[l];
        maxDamage = maxDamageArray[l] * 3 << j;
        maxStackSize = 1;
    }

}

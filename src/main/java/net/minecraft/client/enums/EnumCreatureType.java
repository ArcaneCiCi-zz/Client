package net.minecraft.client.enums;


import net.minecraft.client.entity.mob.impl.EntityAnimals;
import net.minecraft.client.interfaces.IMobs;

public enum EnumCreatureType {
    monster(IMobs.class, 100),
    creature(EntityAnimals.class, 20);

    /*
        public static final EnumCreatureType monster;
        public static final EnumCreatureType creature;
    */
    public final Class field_4278_c;
    public final int maxNumberOfEntityType;
    /*
        public static EnumCreatureType[] func_4145_values()
        {
            return (EnumCreatureType[])field_6518_e.clone();
        }

        public static EnumCreatureType valueOf(String s)
        {
            return (EnumCreatureType)Enum.valueOf(EnumCreatureType.class, s);
        }
    */
    EnumCreatureType(Class class1, int j) {
        field_4278_c = class1;
        maxNumberOfEntityType = j;
    }
/*
    private static final EnumCreatureType field_6518_e[];
/*
    static 
    {
        monster = new EnumCreatureType("monster", 0, IMobs.class, 100);
        creature = new EnumCreatureType("creature", 1, EntityAnimals.class, 20);
        field_6518_e = (new EnumCreatureType[] {
            monster, creature
        });
    }
*/
}

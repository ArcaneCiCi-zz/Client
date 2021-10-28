package net.minecraft.client.entity.mob.impl;


import net.minecraft.client.entity.Entity;
import net.minecraft.client.entity.player.EntityLiving;
import net.minecraft.client.nbt.NBTTagCompound;
import net.minecraft.client.world.World;

import java.util.HashMap;
import java.util.Map;

public class EntityList {

    private static final Map stringToClassMapping = new HashMap();
    private static final Map classToStringMapping = new HashMap();
    private static final Map IDtoClassMapping = new HashMap();
    private static final Map classToIDMapping = new HashMap();

    static {
        addMapping(EntityArrow.class, "Arrow", 10);
        addMapping(EntitySnowball.class, "Snowball", 11);
        addMapping(EntityItem.class, "Item", 1);
        addMapping(EntityPainting.class, "Painting", 9);
        addMapping(EntityLiving.class, "Mob", 48);
        addMapping(EntityMobs.class, "Monster", 49);
        addMapping(EntityCreeper.class, "Creeper", 50);
        addMapping(EntitySkeleton.class, "Skeleton", 51);
        addMapping(EntitySpider.class, "Spider", 52);
        addMapping(EntityZombieSimple.class, "Giant", 53);
        addMapping(EntityZombie.class, "Zombie", 54);
        addMapping(EntitySlime.class, "Slime", 55);
        addMapping(EntityGhast.class, "Ghast", 56);
        addMapping(EntityPigZombie.class, "PigZombie", 57);
        addMapping(EntityPig.class, "Pig", 90);
        addMapping(EntitySheep.class, "Sheep", 91);
        addMapping(EntityCow.class, "Cow", 92);
        addMapping(EntityChicken.class, "Chicken", 93);
        addMapping(EntityTNTPrimed.class, "PrimedTnt", 20);
        addMapping(EntityFallingSand.class, "FallingSand", 21);
        addMapping(EntityMinecart.class, "Minecart", 40);
        addMapping(EntityBoat.class, "Boat", 41);
    }

    public EntityList() {
    }

    private static void addMapping(Class class1, String s, int i) {
        stringToClassMapping.put(s, class1);
        classToStringMapping.put(class1, s);
        IDtoClassMapping.put(Integer.valueOf(i), class1);
        classToIDMapping.put(class1, Integer.valueOf(i));
    }

    public static Entity createEntityInWorld(String s, World world) {
        Entity entity = null;
        try {
            Class class1 = (Class) stringToClassMapping.get(s);
            if (class1 != null) {
                entity = (Entity) class1.getConstructor(new Class[]{
                        World.class
                }).newInstance(new Object[]{
                        world
                });
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return entity;
    }

    public static Entity createEntityFromNBT(NBTTagCompound nbttagcompound, World world) {
        Entity entity = null;
        try {
            Class class1 = (Class) stringToClassMapping.get(nbttagcompound.getString("id"));
            if (class1 != null) {
                entity = (Entity) class1.getConstructor(new Class[]{
                        World.class
                }).newInstance(new Object[]{
                        world
                });
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity != null) {
            entity.readFromNBT(nbttagcompound);
        } else {
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(nbttagcompound.getString("id")));
        }
        return entity;
    }

    public static Entity createEntity(int i, World world) {
        Entity entity = null;
        try {
            Class class1 = (Class) IDtoClassMapping.get(Integer.valueOf(i));
            if (class1 != null) {
                entity = (Entity) class1.getConstructor(new Class[]{
                        World.class
                }).newInstance(new Object[]{
                        world
                });
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity == null) {
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(i));
        }
        return entity;
    }

    public static int getEntityID(Entity entity) {
        return ((Integer) classToIDMapping.get(entity.getClass())).intValue();
    }

    public static String getEntityString(Entity entity) {
        return (String) classToStringMapping.get(entity.getClass());
    }
}

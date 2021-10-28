package net.minecraft.client.misc;


public class HashEntry {

    final int hashEntry;
    final int slotHash;
    Object valueEntry;
    HashEntry nextEntry;

    public HashEntry(int i, int j, Object obj, HashEntry hashentry) {
        valueEntry = obj;
        nextEntry = hashentry;
        hashEntry = j;
        slotHash = i;
    }

    public final int getHash() {
        return hashEntry;
    }

    public final Object getValue() {
        return valueEntry;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof HashEntry)) {
            return false;
        }
        HashEntry hashentry = (HashEntry) obj;
        Integer integer = Integer.valueOf(getHash());
        Integer integer1 = Integer.valueOf(hashentry.getHash());
        if (integer == integer1 || integer != null && integer.equals(integer1)) {
            Object obj1 = getValue();
            Object obj2 = hashentry.getValue();
            return obj1 == obj2 || obj1 != null && obj1.equals(obj2);
        }
        return false;
    }

    public final int hashCode() {
        return MCHashTable.getHash(hashEntry);
    }

    public final String toString() {
        return (new StringBuilder()).append(getHash()).append("=").append(getValue()).toString();
    }
}

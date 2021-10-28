package net.minecraft.client.recipe;


import net.minecraft.client.ui.crafting.CraftingManager;
import net.minecraft.client.ui.crafting.impl.CraftingRecipe;

import java.util.Comparator;

public class RecipeSorter
        implements Comparator {

    final CraftingManager field_1557_a;

    public RecipeSorter(CraftingManager craftingmanager) {
        field_1557_a = craftingmanager;
    }

    public int func_1040_a(CraftingRecipe craftingrecipe, CraftingRecipe craftingrecipe1) {
        if (craftingrecipe1.getRecipeSize() < craftingrecipe.getRecipeSize()) {
            return -1;
        }
        return craftingrecipe1.getRecipeSize() <= craftingrecipe.getRecipeSize() ? 0 : 1;
    }

    public int compare(Object obj, Object obj1) {
        return func_1040_a((CraftingRecipe) obj, (CraftingRecipe) obj1);
    }
}

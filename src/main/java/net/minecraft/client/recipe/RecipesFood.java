package net.minecraft.client.recipe;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.ui.crafting.CraftingManager;

public class RecipesFood {

    public RecipesFood() {
    }

    public void func_976_a(CraftingManager craftingmanager) {
        craftingmanager.addRecipe(new ItemStack(Item.bowlSoup), new Object[]{
                "Y", "X", "#", Character.valueOf('X'), Block.mushroomBrown, Character.valueOf('Y'), Block.mushroomRed, Character.valueOf('#'), Item.bowlEmpty
        });
        craftingmanager.addRecipe(new ItemStack(Item.bowlSoup), new Object[]{
                "Y", "X", "#", Character.valueOf('X'), Block.mushroomRed, Character.valueOf('Y'), Block.mushroomBrown, Character.valueOf('#'), Item.bowlEmpty
        });
    }
}

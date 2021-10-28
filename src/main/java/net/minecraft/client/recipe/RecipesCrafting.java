package net.minecraft.client.recipe;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.ui.crafting.CraftingManager;

public class RecipesCrafting {

    public RecipesCrafting() {
    }

    public void func_1051_a(CraftingManager craftingmanager) {
        craftingmanager.addRecipe(new ItemStack(Block.chest), new Object[]{
                "###", "# #", "###", Character.valueOf('#'), Block.planks
        });
        craftingmanager.addRecipe(new ItemStack(Block.stoneOvenIdle), new Object[]{
                "###", "# #", "###", Character.valueOf('#'), Block.cobblestone
        });
        craftingmanager.addRecipe(new ItemStack(Block.workbench), new Object[]{
                "##", "##", Character.valueOf('#'), Block.planks
        });
    }
}

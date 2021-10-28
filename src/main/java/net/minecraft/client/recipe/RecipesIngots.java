package net.minecraft.client.recipe;


import net.minecraft.client.blocks.Block;
import net.minecraft.client.item.Item;
import net.minecraft.client.item.impl.ItemStack;
import net.minecraft.client.ui.crafting.CraftingManager;

public class RecipesIngots {

    private final Object[][] field_1198_a;

    public RecipesIngots() {
        field_1198_a = (new Object[][]{
                new Object[]{
                        Block.blockGold, Item.ingotGold
                }, new Object[]{
                Block.blockSteel, Item.ingotIron
        }, new Object[]{
                Block.blockDiamond, Item.diamond
        }
        });
    }

    public void func_810_a(CraftingManager craftingmanager) {
        for (int i = 0; i < field_1198_a.length; i++) {
            Block block = (Block) field_1198_a[i][0];
            Item item = (Item) field_1198_a[i][1];
            craftingmanager.addRecipe(new ItemStack(block), new Object[]{
                    "###", "###", "###", Character.valueOf('#'), item
            });
            craftingmanager.addRecipe(new ItemStack(item, 9), new Object[]{
                    "#", Character.valueOf('#'), block
            });
        }

    }
}

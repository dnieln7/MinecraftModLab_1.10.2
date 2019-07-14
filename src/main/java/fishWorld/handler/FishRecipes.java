package fishWorld.handler;

import fishWorld.armor.FishArmor;
import fishWorld.block.FishBlocks;
import fishWorld.item.FishItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FishRecipes
{
    public static void register()
    {
        smelting();
        item();
        tool();
        armor();
        block();
    }

    private static void smelting()
    {
        GameRegistry.addSmelting(FishBlocks.coral_block, new ItemStack(FishItems.coral_sword), 0.7F);
    }

    private static void item()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(FishItems.coral_chunk, 9), FishBlocks.coral_block);

        GameRegistry.addRecipe(new ItemStack(FishItems.creative_staff), " X ", " Y ", " Y ", 'X', Blocks.REDSTONE_BLOCK, 'Y', Items.STICK);
        GameRegistry.addShapelessRecipe(new ItemStack(FishItems.spawner), Items.SKULL);
    }

    public static void tool()
    {
        GameRegistry.addRecipe(new ItemStack(FishItems.coral_sword), " X ", " X ", " Y ", 'X', FishItems.coral_chunk, 'Y', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(FishItems.coral_pickaxe), "XXX", " Y ", " Y ", 'X', FishItems.coral_chunk, 'Y', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(FishItems.coral_axe), "XX ", "XY ", " Y ", 'X', FishItems.coral_chunk, 'Y', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(FishItems.coral_shovel), " X ", " Y ", " Y ", 'X', FishItems.coral_chunk, 'Y', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(FishItems.coral_hoe), "XX ", " Y ", " Y ", 'X', FishItems.coral_chunk, 'Y', Items.STICK);
    }

    private static void armor()
    {
        GameRegistry.addRecipe(new ItemStack(FishArmor.coral_helmet), "XXX", "X X", "   ", 'X', FishItems.coral_chunk);
        GameRegistry.addRecipe(new ItemStack(FishArmor.coral_chestplate), "X X", "XXX", "XXX", 'X', FishItems.coral_chunk);
        GameRegistry.addRecipe(new ItemStack(FishArmor.coral_leggings), "XXX", "X X", "X X", 'X', FishItems.coral_chunk);
        GameRegistry.addRecipe(new ItemStack(FishArmor.coral_boots), "X X", "X X", "   ", 'X', FishItems.coral_chunk);
    }

    private static void block()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(FishBlocks.coral_block),
                FishItems.coral_chunk,
                FishItems.coral_chunk,
                FishItems.coral_chunk,
                FishItems.coral_chunk,
                FishItems.coral_chunk,
                FishItems.coral_chunk,
                FishItems.coral_chunk,
                FishItems.coral_chunk,
                FishItems.coral_chunk);
    }
}

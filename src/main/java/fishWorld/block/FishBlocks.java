package fishWorld.block;

import fishWorld.FishWorld;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FishBlocks
{
    public static Block coral_block;
    public static Block gunpower_ore;
    public static Block altar;

    public static void register()
    {
        coral_block = new Coral_block("coral_block", Material.ROCK);
        gunpower_ore = new Gunpowder_ore("gunpowder_ore", Material.ROCK);
        altar = new Altar("altar", Material.ROCK);

        registerBlock(coral_block, "coral_block");
        registerBlock(gunpower_ore, "gunpowder_ore");
        registerBlock(altar, "altar");
    }

    private static void registerBlock(Block block, String name)
    {
        GameRegistry.register(block, new ResourceLocation(FishWorld.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(FishWorld.MODID, name));
    }

    public static void registerRenders()
    {
        registerRender(coral_block);
        registerRender(gunpower_ore);
        registerRender(altar);
    }

    private static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);

        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(FishWorld.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}

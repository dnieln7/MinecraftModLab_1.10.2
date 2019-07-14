package fishWorld.item;

import fishWorld.handler.FishMaterial;
import fishWorld.FishWorld;
import fishWorld.handler.FuelItems;
import fishWorld.handler.ItemTypes.PearlTypes;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FishItems
{
    public static Item coral_chunk;

    public static Item creative_staff;
    public static Item spawner;

    public static ItemSword coral_sword;
    public static ItemPickaxe coral_pickaxe;
    public static ItemAxe coral_axe;
    public static ItemSpade coral_shovel;
    public static ItemHoe coral_hoe;

    public static ItemFood mosty_bread;

    public static Item pearl;

    public static void register()
    {
        init();

        GameRegistry.register(coral_chunk, new ResourceLocation(FishWorld.MODID, "coral_chunk"));

        GameRegistry.register(creative_staff, new ResourceLocation(FishWorld.MODID, "creative_staff"));
        GameRegistry.register(spawner, new ResourceLocation(FishWorld.MODID, "spawner"));

        GameRegistry.register(coral_sword, new ResourceLocation(FishWorld.MODID, "coral_sword"));
        GameRegistry.register(coral_pickaxe, new ResourceLocation(FishWorld.MODID, "coral_pickaxe"));
        GameRegistry.register(coral_axe, new ResourceLocation(FishWorld.MODID, "coral_axe"));
        GameRegistry.register(coral_shovel, new ResourceLocation(FishWorld.MODID, "coral_shovel"));
        GameRegistry.register(coral_hoe, new ResourceLocation(FishWorld.MODID, "coral_hoe"));

        GameRegistry.register(mosty_bread, new ResourceLocation(FishWorld.MODID, "mosty_bread"));

        GameRegistry.register(pearl, new ResourceLocation(FishWorld.MODID, "pearl"));

        registerFuel();
    }

    public static void registerRenders()
    {
        registerRender(coral_chunk);

        registerRender(creative_staff);
        registerRender(spawner);

        registerRender(coral_sword);
        registerRender(coral_pickaxe);
        registerRender(coral_axe);
        registerRender(coral_shovel);
        registerRender(coral_hoe);

        registerRender(mosty_bread);

        for(int i = 0; i < PearlTypes.values().length; i++)
        {
            registerRender(pearl, i, "pearl_" + PearlTypes.values()[i].getName());
            System.out.println(PearlTypes.values()[i].getName());
        }
    }

    private static void init()
    {
        coral_chunk = new Coral_chunk("coral_chunk");

        creative_staff = new Creative_staff("creative_staff");
        spawner = new Spawner("spawner");

        coral_sword = new Coral_sword("coral_sword", FishMaterial.coral_tool);
        coral_pickaxe = new Coral_pickaxe("coral_pickaxe", FishMaterial.coral_tool);
        coral_axe = new Coral_axe("coral_axe", FishMaterial.coral_tool);
        coral_shovel = new Coral_shovel("coral_shovel", FishMaterial.coral_tool);
        coral_hoe = new Coral_hoe("coral_hoe", FishMaterial.coral_tool);

        mosty_bread = new Mosty_bread("mosty_bread", 2, 2, false);

        pearl = new Pearl("pearl");
    }

    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(FishWorld.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    private static void registerRender(Item item, int meta, String textureName)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(FishWorld.MODID + ":" + textureName, "inventory"));
    }

    private static void registerFuel()
    {
        GameRegistry.registerFuelHandler(new FuelItems());
    }
}

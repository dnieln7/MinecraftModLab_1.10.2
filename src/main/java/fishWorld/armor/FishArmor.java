package fishWorld.armor;

import fishWorld.handler.FishMaterial;
import fishWorld.FishWorld;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FishArmor
{
    public static ItemArmor coral_helmet;
    public static ItemArmor coral_chestplate;
    public static ItemArmor coral_leggings;
    public static ItemArmor coral_boots;

    public static void register()
    {
        init();

        GameRegistry.register(coral_helmet, new ResourceLocation(FishWorld.MODID, "coral_helmet"));;
        GameRegistry.register(coral_chestplate, new ResourceLocation(FishWorld.MODID, "coral_chestplate"));
        GameRegistry.register(coral_leggings, new ResourceLocation(FishWorld.MODID, "coral_leggings"));
        GameRegistry.register(coral_boots, new ResourceLocation(FishWorld.MODID, "coral_boots"));
    }

    public static void registerRenders()
    {
        registerRender(coral_helmet);
        registerRender(coral_chestplate);
        registerRender(coral_leggings);
        registerRender(coral_boots);
    }

    private static void init()
    {
        coral_helmet = new CoralSet("coral_helmet", FishMaterial.coral_armor, 1, EntityEquipmentSlot.HEAD);
        coral_chestplate = new CoralSet("coral_chestplate", FishMaterial.coral_armor, 1, EntityEquipmentSlot.CHEST);
        coral_leggings = new CoralSet("coral_leggings", FishMaterial.coral_armor, 1, EntityEquipmentSlot.LEGS);
        coral_boots = new CoralSet("coral_boots", FishMaterial.coral_armor, 1, EntityEquipmentSlot.FEET);
    }

    private static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(FishWorld.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}

package fishWorld.handler;

import fishWorld.FishWorld;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class FishMaterial
{
    public static final ToolMaterial coral_tool = EnumHelper.addToolMaterial("coral_tool", 2, 400, 7, 2.5F, 15);

    public static final ArmorMaterial coral_armor = EnumHelper.addArmorMaterial("coral_armor", FishWorld.MODID + ":coral",24, new int[]{3,5,7,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
}

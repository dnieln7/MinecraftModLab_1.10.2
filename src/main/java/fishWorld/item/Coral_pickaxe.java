package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.item.ItemPickaxe;

public class Coral_pickaxe extends ItemPickaxe
{
    public Coral_pickaxe(String name, ToolMaterial material)
    {
        super(material);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setMaxStackSize(1);
    }
}

package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.item.ItemAxe;

public class Coral_axe extends ItemAxe
{
    public Coral_axe(String name, ToolMaterial material)
    {
        super(material, 1F, 1F);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setMaxStackSize(1);
    }
}

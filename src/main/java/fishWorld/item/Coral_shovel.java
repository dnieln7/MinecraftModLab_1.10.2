package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.item.ItemSpade;

public class Coral_shovel extends ItemSpade
{
    public Coral_shovel(String name, ToolMaterial material)
    {
        super(material);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setMaxStackSize(1);
    }
}

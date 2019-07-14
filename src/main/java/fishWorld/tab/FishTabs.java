package fishWorld.tab;

import net.minecraft.creativetab.CreativeTabs;

public class FishTabs
{
    protected static final String Background = "Background.png";

    public static ItemsTab itemsTab;
    public static CreativeTabs blocksTab;

    public static void register()
    {
        itemsTab = new ItemsTab(CreativeTabs.getNextID(), "Fish_Items");
        blocksTab = new BlocksTab(CreativeTabs.getNextID(), "Fish_Blocks");
    }
}

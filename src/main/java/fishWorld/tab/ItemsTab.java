package fishWorld.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ItemsTab extends CreativeTabs
{

    public ItemsTab(int index, String label)
    {
        super(index, label);
    }

    @Override
    public Item getTabIconItem()
    {
        return Items.FISHING_ROD;
    }

    @Override
    public String getBackgroundImageName()
    {
        return FishTabs.Background;
    }
}

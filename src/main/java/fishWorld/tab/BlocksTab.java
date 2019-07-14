package fishWorld.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlocksTab extends CreativeTabs {

    public BlocksTab(int index, String label)
    {
        super(index, label);
    }

    @Override
    public Item getTabIconItem()
    {
        return Items.DIAMOND;
    }

    @Override
    public String getBackgroundImageName()
    {
        return FishTabs.Background;
    }
}

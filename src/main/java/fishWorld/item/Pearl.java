package fishWorld.item;

import fishWorld.handler.ItemTypes.PearlTypes;
import fishWorld.tab.FishTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import java.util.List;

public class Pearl extends Item
{
    public Pearl(String name)
    {
        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
    }

    @Override
    public boolean getHasSubtypes()
    {
        return true;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for(int i = 0; i < PearlTypes.values().length; i++)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        for(int i = 0;i < PearlTypes.values().length;i++)
        {
            if(stack.getItemDamage() == i)
            {
                return this.getUnlocalizedName() + "." + PearlTypes.values()[i].getName();
            }
        }

        return this.getUnlocalizedName();
    }
}

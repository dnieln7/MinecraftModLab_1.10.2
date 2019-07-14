package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class Coral_chunk extends Item
{

    public Coral_chunk(String name)
    {
        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {

        tooltip.add(TextFormatting.AQUA + "Also used as fuel");
    }
}

package fishWorld.handler;

import fishWorld.item.FishItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelItems implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if(fuel.getItem() == FishItems.coral_chunk)
        {
            return 200;
        }

        return 0;
    }
}

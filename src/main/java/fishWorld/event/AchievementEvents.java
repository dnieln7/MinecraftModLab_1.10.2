package fishWorld.event;

import fishWorld.block.FishBlocks;
import fishWorld.handler.FishAchievements;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class AchievementEvents
{
    @SubscribeEvent
    public void firstBlock(ItemCraftedEvent event)
    {
        if(!event.player.hasAchievement(FishAchievements.firstBlock))
        {
            if(event.crafting.getItem().equals(Item.getItemFromBlock(FishBlocks.coral_block)))
            {
                event.player.addStat(FishAchievements.firstBlock);
            }
        }
    }
}

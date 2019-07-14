package fishWorld.handler;

import fishWorld.FishWorld;
import fishWorld.block.FishBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import java.util.ArrayList;
import java.util.List;

public class FishAchievements
{
    private static List<Achievement> achivements = new ArrayList<Achievement>();

    public static  Achievement firstBlock = create("firstBlock", 0, 0, FishBlocks.coral_block);

    public static void register()
    {
        Achievement[] achievementsArray = new Achievement[achivements.size()];

        for(Achievement achievement : achivements)
        {
            achievement.registerStat();
            achievementsArray[achivements.indexOf(achievement)] = achievement;
        }

        AchievementPage.registerAchievementPage(new AchievementPage(FishWorld.NAME, achievementsArray));
    }

    private static Achievement create(String name, int column, int row, Item item)
    {
        Achievement achievement =  new Achievement("achievement." + name, name, column, row, item, (Achievement) null);

        achivements.add(achievement);

        return achievement;
    }

    private static Achievement create(String name, int column, int row, Block block)
    {
        Achievement achievement =  new Achievement("achievement." + name, name, column, row, block, (Achievement) null);

        achivements.add(achievement);

        return achievement;
    }

    private static Achievement create(String name, int column, int row, ItemStack itemStack)
    {
        Achievement achievement =  new Achievement("achievement." + name, name, column, row, itemStack, (Achievement) null);

        achivements.add(achievement);

        return achievement;
    }
}

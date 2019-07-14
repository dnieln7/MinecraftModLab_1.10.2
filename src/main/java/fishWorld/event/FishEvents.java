package fishWorld.event;

import net.minecraftforge.common.MinecraftForge;

public class FishEvents
{
   public static void register()
   {
       MinecraftForge.EVENT_BUS.register(new Normal());
       MinecraftForge.EVENT_BUS.register(new AchievementEvents());
   }
}

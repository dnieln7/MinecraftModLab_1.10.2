package fishWorld;

import fishWorld.armor.FishArmor;
import fishWorld.block.FishBlocks;
import fishWorld.event.FishEvents;
import fishWorld.handler.FishAchievements;
import fishWorld.item.FishItems;
import fishWorld.proxy.CommonProxy;
import fishWorld.handler.FishRecipes;
import fishWorld.tab.FishTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid =  FishWorld.MODID, version = FishWorld.VERSION, name = FishWorld.NAME)

public class FishWorld
{
    public static final String MODID = "fishworld";
    public static final String VERSION = "1.0";
    public static final String NAME = "Fish World";

    @SidedProxy(clientSide = "fishWorld.proxy.ClientProxy", serverSide = "fishWorld.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance
    public static FishWorld instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FishTabs.register();
        FishItems.register();
        FishBlocks.register();
        FishArmor.register();
        FishAchievements.register();

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        FishRecipes.register();

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        FishEvents.register();

        proxy.postInit(event);
    }
}

package fishWorld.proxy;

import fishWorld.FishWorld;
import fishWorld.worldGen.FishGen;
import fishWorld.armor.FishArmor;
import fishWorld.block.FishBlocks;
import fishWorld.gui.FishGUI;
import fishWorld.item.FishItems;
import fishWorld.handler.ItemTypes.PearlTypes;
import fishWorld.tileEntity.FishTileEntity;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        FishItems.registerRenders();
        FishBlocks.registerRenders();
        FishArmor.registerRenders();
        FishGen.register();
        FishTileEntity.register();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        ModelBakery.registerItemVariants(FishItems.pearl, PearlTypes.getResourceLocations());
        NetworkRegistry.INSTANCE.registerGuiHandler(FishWorld.instance, new FishGUI());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}

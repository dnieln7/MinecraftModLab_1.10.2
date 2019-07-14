package fishWorld.tileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class FishTileEntity
{
    public static void register()
    {
        GameRegistry.registerTileEntity(TileEntityCoralBlock.class, "coral");
        GameRegistry.registerTileEntity(TileEntityAltar.class, "altar");
    }
}

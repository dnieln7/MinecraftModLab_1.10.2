package fishWorld.worldGen;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class FishGen
{
	public static void register()
	{
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}
}

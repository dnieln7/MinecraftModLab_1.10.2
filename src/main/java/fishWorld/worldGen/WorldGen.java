package fishWorld.worldGen;

import com.google.common.base.Predicate;
import fishWorld.block.FishBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import javax.annotation.Nullable;
import java.util.Random;

public class WorldGen implements IWorldGenerator
{
	private class NetherPredicate implements Predicate<IBlockState>
	{
		@Override
		public boolean apply(@Nullable IBlockState input)
		{
			return input != null && input.getBlock().equals(Blocks.NETHERRACK);
		}
	}

	private class EndPredicate implements Predicate<IBlockState>
	{
		@Override
		public boolean apply(@Nullable IBlockState input)
		{
			return input != null && input.getBlock().equals(Blocks.END_STONE);
		}
	}

	private WorldGenerator gunpowder_overworld;
	private WorldGenerator gunpowder_nether;
	private WorldGenerator gunpowder_end;

	public WorldGen()
	{
		gunpowder_overworld = new WorldGenMinable(FishBlocks.gunpower_ore.getDefaultState(), 8);
		gunpowder_nether = new WorldGenMinable(FishBlocks.gunpower_ore.getDefaultState(), 8, new NetherPredicate());
		gunpowder_end = new WorldGenMinable(FishBlocks.gunpower_ore.getDefaultState(), 8, new EndPredicate());
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimension())
		{
			case -1:
				generateNether(world, random, chunkX, chunkZ);
				break;
			case 0:
				generateOverworld(world, random, chunkX, chunkZ);
				break;
			case 1:
				generateEnd(world, random, chunkX, chunkZ);
				break;
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{

	}

	public void generateOverworld(World world, Random random, int chunkX, int chunkZ)
	{
        generateOre(gunpowder_overworld, world, random, chunkX, chunkZ, 20, 64,10);
	}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{

	}

    private void generateOre(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int minY, int maxY, int chances)
    {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++)
        {
            BlockPos pos = new BlockPos((chunkX * 16) + random.nextInt(16), minY + random.nextInt(deltaY), (chunkZ * 16) + random.nextInt(16));

            generator.generate(world, random, pos);
        }
    }
}

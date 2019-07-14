package fishWorld.block;

import fishWorld.tab.FishTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class Gunpowder_ore extends Block
{
    public Gunpowder_ore(String name, Material rock)
    {
        super(rock);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.blocksTab);
        setHardness(5F);
        setSoundType(SoundType.STONE);
    }

    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.GUNPOWDER;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return 3 + fortune;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        return 2 + fortune;
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return true;
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
        Entity entity = new EntitySilverfish(worldIn);

        entity.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);

        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(entity);
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
        this.onBlockDestroyedByPlayer(worldIn, pos, worldIn.getBlockState(pos));
    }
}

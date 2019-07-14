package fishWorld.block;

import fishWorld.tab.FishTabs;
import fishWorld.tileEntity.TileEntityCoralBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Coral_block extends Block implements ITileEntityProvider
{
    public Coral_block(String name, Material blockMaterialIn)
    {
        super(blockMaterialIn);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.blocksTab);
        setHardness(5F);
        setResistance(10F);
        setSoundType(SoundType.STONE);
        setLightLevel(1F);
    }


    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityCoralBlock();
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityCoralBlock();
    }
}

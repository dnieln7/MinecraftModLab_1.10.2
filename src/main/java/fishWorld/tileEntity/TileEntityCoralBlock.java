package fishWorld.tileEntity;

import fishWorld.block.FishBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityCoralBlock extends TileEntity implements ITickable
{
    private int cooldown;

    public TileEntityCoralBlock()
    {
        this.cooldown = 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        this.cooldown = compound.getInteger("cooldown");
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound.setInteger("cooldown", this.cooldown);

        return super.writeToNBT(compound);
    }

    @Override
    public void update()
    {
        if(this.worldObj != null && !this.worldObj.isRemote)
        {
            if(worldObj.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.GLOWSTONE)
            {
                this.cooldown++;
                this.cooldown %= 100;

                if (this.cooldown == 0)
                {

                    BlockPos initialPos = pos.offset(EnumFacing.DOWN);
                    BlockPos eastPos = initialPos.offset(EnumFacing.EAST);
                    BlockPos westPos = initialPos.offset(EnumFacing.WEST);
                    BlockPos northPos = initialPos.offset(EnumFacing.NORTH);
                    BlockPos southPos = initialPos.offset(EnumFacing.SOUTH);

                    this.worldObj.setBlockState(initialPos, FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(eastPos, FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(westPos, FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(northPos, FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(southPos, FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(eastPos.offset(EnumFacing.NORTH), FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(eastPos.offset(EnumFacing.SOUTH), FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(westPos.offset(EnumFacing.NORTH), FishBlocks.coral_block.getDefaultState());
                    this.worldObj.setBlockState(westPos.offset(EnumFacing.SOUTH), FishBlocks.coral_block.getDefaultState());
                }
            }
        }
    }
}

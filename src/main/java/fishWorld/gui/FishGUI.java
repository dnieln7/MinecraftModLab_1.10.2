package fishWorld.gui;

import fishWorld.container.ContainerAltar;
import fishWorld.tileEntity.TileEntityAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class FishGUI implements IGuiHandler
{

    public static final int ALTAR = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == ALTAR)
        {
            return new ContainerAltar(player.inventory, (TileEntityAltar) world.getTileEntity(new BlockPos(x, y, z)));
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == ALTAR)
        {
            return new GUIAltar(player.inventory, (TileEntityAltar) world.getTileEntity(new BlockPos(x, y, z)));
        }

        return null;
    }
}

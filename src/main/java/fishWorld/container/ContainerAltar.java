package fishWorld.container;

import fishWorld.tileEntity.TileEntityAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerAltar extends Container
{
    private TileEntityAltar altar;
    private IItemHandler inventory;

    public ContainerAltar(IInventory playerInventory, TileEntityAltar altar)
    {
        this.altar = altar;
        this.inventory = altar.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        this.addSlotToContainer(new SlotItemHandler(inventory, 0, 80, 35));

        int x = 8;
        int y = 84;

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, x + j * 18, y + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(playerInventory, i, x + i * 18, y + 58));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return !playerIn.isSpectator();
    }


}

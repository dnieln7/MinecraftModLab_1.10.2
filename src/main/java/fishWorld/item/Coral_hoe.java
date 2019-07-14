package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Coral_hoe extends ItemHoe
{
    public Coral_hoe(String name, ToolMaterial material)
    {
        super(material);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote)
        {
            worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 5, true);

            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.FAIL;
    }
}

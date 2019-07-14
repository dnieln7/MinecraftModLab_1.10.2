package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Coral_sword extends ItemSword
{
    public Coral_sword(String name, ToolMaterial material)
    {
        super(material);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setMaxStackSize(1);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        return super.hitEntity(stack, target, attacker);
    }
}

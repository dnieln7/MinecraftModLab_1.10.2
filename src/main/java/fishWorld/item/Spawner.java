package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Spawner extends Item
{
    private Entity entity;

    public Spawner(String name)
    {
        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        entity = new EntityCreeper(worldIn);

        entity.setLocationAndAngles(pos.getX(), pos.getY() + 1, pos.getZ(), 0, 0);

        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(entity);

            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.FAIL;
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        worldIn.addWeatherEffect(new EntityLightningBolt(worldIn,
                Minecraft.getMinecraft().thePlayer.posX,
                Minecraft.getMinecraft().thePlayer.posY,
                Minecraft.getMinecraft().thePlayer.posZ,
                false));

        super.onCreated(stack, worldIn, playerIn);
    }
}

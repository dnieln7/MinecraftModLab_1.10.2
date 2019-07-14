package fishWorld.event;

import fishWorld.FishWorld;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class Normal
{
    @SubscribeEvent
    public void entityJoinWolrd(EntityJoinWorldEvent event)
    {
        if(event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.getEntity();


            if(!event.getWorld().isRemote)
            {
                player.addChatComponentMessage(new TextComponentString("Mod version: " + FishWorld.VERSION));
            }
        }
    }

    @SubscribeEvent
    public void livingDrops(LivingDropsEvent event)
    {
        if(event.getEntity() instanceof EntityCreeper)
        {
            event.getDrops().add(new EntityItem
                    (event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(Blocks.TNT)));
        }
    }

    @SubscribeEvent
    public void livingHurt(LivingHurtEvent event)
    {
        if(event.getSource().getEntity() instanceof EntityPlayer)
        {

        }
    }

    @SubscribeEvent
    public void itemPickup(PlayerEvent.ItemPickupEvent event)
    {
        if(event.pickedUp.getEntityItem().getItem() == Items.GLOWSTONE_DUST)
        {

        }
    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event)
    {
        if(event.getEntity() instanceof  EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.getEntity();

            if(player.getHeldItemMainhand() != null)
            {
                if(player.getHeldItem(EnumHand.MAIN_HAND).getItem() == Items.GLOWSTONE_DUST)
                {

                }
            }
        }
    }

    @SubscribeEvent
    public void itemTooltip(ItemTooltipEvent event)
    {
        if(event.getItemStack().getItem() == Items.GLOWSTONE_DUST)
        {
            event.getToolTip().add("Also used in: ");
        }
    }

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        if(event.getState().getBlock() == Blocks.GLOWSTONE)
        {
            BlockPos pos = event.getPos();

            event.getWorld().spawnEntityInWorld(new EntityItem
                    ( event.getWorld(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Blocks.TNT)));
        }
    }
}

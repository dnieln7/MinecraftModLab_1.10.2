package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

import java.util.List;

public class Creative_staff extends Item
{
    public Creative_staff(String name)
    {
        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setMaxStackSize(1);
        setMaxDamage(100);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        tooltip.add("Shift + Right Click -> Creative");
        tooltip.add("Right Click -> Survival");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(!worldIn.isRemote)
        {
            if (playerIn.isSneaking())
            {
                playerIn.setGameType(GameType.CREATIVE);
                playerIn.addChatComponentMessage(new TextComponentString("Game set to Creative!"));

                if(worldIn.isRaining() || worldIn.isThundering() || !worldIn.isDaytime())
                {
                    worldIn.setWorldTime(1000);
                }
            }
            else
            {
                playerIn.setGameType(GameType.SURVIVAL);

                playerIn.setHealth(100f);
                playerIn.getFoodStats().setFoodLevel(20);

                playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1200, 3));
                playerIn.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 1200, 1));
                playerIn.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1200, 1));

                playerIn.addChatComponentMessage(new TextComponentString("Game set to Survival!"));
            }
        }

        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}

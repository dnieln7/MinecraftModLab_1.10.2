package fishWorld.item;

import fishWorld.tab.FishTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Mosty_bread extends ItemFood
{
    public Mosty_bread(String name, int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
        setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 20, 0));
    }
}

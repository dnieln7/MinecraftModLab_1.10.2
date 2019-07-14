package fishWorld.armor;

import fishWorld.tab.FishTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Iterator;

public class CoralSet extends ItemArmor
{

    public CoralSet(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, renderIndexIn, equipmentSlotIn);

        setUnlocalizedName(name);
        setCreativeTab(FishTabs.itemsTab);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        ItemStack[] armor = player.inventory.armorInventory;

        if(armor.length > 0)
        {
            int count = 0;

            for (ItemStack i : armor)
            {
                if(i != null && i.getItem() instanceof CoralSet)
                {
                    count++;
                }
            }

            switch (count)
            {
                case 1:
                    player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 0));
                    break;
                case 2:
                    player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 0));
                    player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 0));
                    break;
                case 3:
                    player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 1));
                    player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 1));
                    break;
                case 4:
                    player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 2));
                    player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 200, 2));
                    break;
            }
        }
    }
}

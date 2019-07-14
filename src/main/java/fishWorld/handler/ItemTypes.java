package fishWorld.handler;

import fishWorld.FishWorld;
import fishWorld.item.FishItems;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public class ItemTypes
{
    ;public enum PearlTypes implements IStringSerializable
    {
        BLACK("black", 0),
        BLUE("blue", 1),
        GREEN("green", 2),
        PINK("pink", 3),
        PURPLE("purple", 4),
        RED("red", 5),
        WHITE("white", 6),
        YELLOW("yellow", 7),
        RAINBOW("rainbow", 8);

        private String name;
        private int id;

        PearlTypes(String name, int id)
        {
            this.name = name;
            this.id = id;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        public int getId()
        {
            return id;
        }

        @Override
        public String toString()
        {
            return getName();
        }

        public static ResourceLocation[] getResourceLocations()
        {
            ResourceLocation[] resourceLocations = new ResourceLocation[PearlTypes.values().length];

            for(int i = 0;i <resourceLocations.length;i++)
            {
                resourceLocations[i] = new ResourceLocation(FishWorld.MODID, FishItems.pearl.getUnlocalizedName().substring(5) + "_" + PearlTypes.values()[i].getName());
            }

            return resourceLocations;
        }
    }
}

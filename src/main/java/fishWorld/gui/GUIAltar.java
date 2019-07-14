package fishWorld.gui;

import fishWorld.FishWorld;
import fishWorld.container.ContainerAltar;
import fishWorld.tileEntity.TileEntityAltar;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class GUIAltar extends GuiContainer
{
    private TileEntityAltar altar;
    private IInventory inventory;
    private static final ResourceLocation background = new ResourceLocation(FishWorld.MODID, "textures/gui/container/altar.png");

    public GUIAltar(IInventory inventory, TileEntityAltar altar)
    {
        super(new ContainerAltar(inventory, altar));

        setGuiSize(176, 166);
        this.altar = altar;
        this.inventory = inventory;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String name = I18n.format("container.altar.name");

        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        fontRendererObj.drawString(inventory.getDisplayName().getUnformattedText(), 8, 72, 0x404040);
    }
}

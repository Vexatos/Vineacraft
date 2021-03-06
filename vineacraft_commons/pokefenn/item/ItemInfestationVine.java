package pokefenn.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import pokefenn.Vineacraft;
import pokefenn.block.ModBlocks;
import pokefenn.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfestationVine extends ItemVineacraft {

	public ItemInfestationVine(int id) {
		super(id);
        this.setUnlocalizedName(Strings.INFESTATION_VINE_NAME);
        this.setCreativeTab(Vineacraft.tabsVineac);
        setMaxStackSize(1);
        this.setMaxDamage(2);
	}
	
	@Override
	 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            int i1 = par3World.getBlockId(par4, par5, par6);
            boolean air = par3World.isAirBlock(par4, par5 + 1, par6);

            if (par7 != 0 && air && (i1 == Block.wood.blockID))
            {
                Block block = ModBlocks.basicMachineBlock;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block.blockID);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }
	


	
	
	

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister register) {
	
	itemIcon = register.registerIcon(ModItems.TEXTURE_LOCATION + ":" + ModItems.INFESTATION_VINE_ICON);       
	
	
}

@Override
@SideOnly(Side.CLIENT)
public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
{
    list.add("Infest wood blocks with a right click!");
}


}
package pokefenn.item;

import cpw.mods.fml.relauncher.SideOnly;
import pokefenn.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;

public class ItemVineacraft extends Item {
    
    public ItemVineacraft(int id) {
    
    super(id = Reference.SHIFTED_ID_RANGE_CORRECTION);
    maxStackSize = 1;
    setNoRepair();
    
    }
    
    


    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
    
    itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    
    
}
}
package pokefenn.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import pokefenn.Vineacraft;
import pokefenn.lib.Strings;
import pokefenn.tileentity.TileManualSqueezer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;



public class BlockManualSqueezer extends BlockVineacraft {

    public BlockManualSqueezer(int id) {
        
        super(id, Material.rock);
        this.setUnlocalizedName(Strings.MANUAL_SQUEEZER_NAME);
        this.setCreativeTab(Vineacraft.tabsVineac);
        this.setHardness(5F);
    }
    
    
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileManualSqueezer();
    }

    
    

    @SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	@SideOnly(Side.CLIENT)
	private Icon botIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		topIcon = register.registerIcon(ModBlocks.TEXTURE_LOCATION + ":" + ModBlocks.MANUAL_SQUEEZER_TOP);
		sideIcon = register.registerIcon(ModBlocks.TEXTURE_LOCATION + ":" + ModBlocks.MANUAL_SQUEEZER_SIDE);
		botIcon = register.registerIcon(ModBlocks.TEXTURE_LOCATION + ":" + ModBlocks.MANUAL_SQUEEZER_BOT);
	
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if(side == 0 ){
			return botIcon;
		}else if(side == 1) {
			return topIcon;
		}else{
			return sideIcon;
		}
		
		
	}
    
    
}

package pokefenn.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerManualSqueezer extends Container {

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return true;
    }

}

package firemuffin303.deepdarker.client.screen;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class InfuserFuelSlot extends Slot {
    private final AbstractInfuserScreenHandler handler;

    public InfuserFuelSlot(AbstractInfuserScreenHandler handler ,Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return this.handler.isFuel(stack);
    }

    public int getMaxItemCount(ItemStack stack){ return super.getMaxItemCount(stack);}
}

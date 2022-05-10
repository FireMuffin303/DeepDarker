package firemuffin303.deepdarker.client.screen;

import firemuffin303.deepdarker.block.entity.AbstractInfusionBlockEntity;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;

public class InfuserOutputSlot extends Slot {
    private final PlayerEntity playerEntity;
    private int amount;

    public InfuserOutputSlot(PlayerEntity playerEntity, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.playerEntity = playerEntity;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    public ItemStack takeStack(int amount) {
        if (this.hasStack()) {
            this.amount += Math.min(amount, this.getStack().getCount());
        }

        return super.takeStack(amount);
    }

    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        this.onCrafted(stack);
        super.onTakeItem(player, stack);
    }

    protected void onCrafted(ItemStack stack, int amount) {
        this.amount += amount;
        this.onCrafted(stack);
    }

    protected void onCrafted(ItemStack stack) {
        stack.onCraft(this.playerEntity.world, this.playerEntity, this.amount);
        if (this.playerEntity instanceof ServerPlayerEntity && this.inventory instanceof AbstractInfusionBlockEntity) {
            ((AbstractInfusionBlockEntity)this.inventory).dropExperienceForRecipesUsed((ServerPlayerEntity)this.playerEntity);
        }

        this.amount = 0;
    }

}

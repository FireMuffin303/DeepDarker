package firemuffin303.deepdarker.item;

import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;

public class AmethystShieldItem extends ShieldItem {
    public AmethystShieldItem(Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 86400;
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.AMETHYST_SHARD) || super.canRepair(stack, ingredient);
    }
}

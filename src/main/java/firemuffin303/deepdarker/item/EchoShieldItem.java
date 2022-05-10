package firemuffin303.deepdarker.item;

import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.tag.ItemTags;

public class EchoShieldItem extends ShieldItem {
    private static int echoCharge = 0;

    public EchoShieldItem(Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 108000;
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(Items.ECHO_SHARD) || super.canRepair(stack, ingredient);
    }
}

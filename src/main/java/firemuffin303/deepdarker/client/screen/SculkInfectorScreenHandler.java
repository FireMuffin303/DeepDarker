package firemuffin303.deepdarker.client.screen;

import firemuffin303.deepdarker.recipe.ModReipeType;
import firemuffin303.deepdarker.recipe.book.ModRecipeBookCategory;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.PropertyDelegate;

public class SculkInfectorScreenHandler extends AbstractInfuserScreenHandler{
    public SculkInfectorScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlerType.SCULK_INFECTOR,ModReipeType.SCULK_INFECTING, RecipeBookCategory.FURNACE,syncId,playerInventory);
    }

    public SculkInfectorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate){
        super(ModScreenHandlerType.SCULK_INFECTOR,ModReipeType.SCULK_INFECTING,RecipeBookCategory.FURNACE,syncId,playerInventory,inventory,propertyDelegate);
    }
}

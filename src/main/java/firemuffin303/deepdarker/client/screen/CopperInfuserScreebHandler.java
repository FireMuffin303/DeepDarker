package firemuffin303.deepdarker.client.screen;

import firemuffin303.deepdarker.recipe.ModReipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.PropertyDelegate;

public class CopperInfuserScreebHandler extends AbstractInfuserScreenHandler{
    public CopperInfuserScreebHandler( int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlerType.COPPER_INFUSER, ModReipeType.INFUSING, RecipeBookCategory.FURNACE, syncId, playerInventory);
    }

    public CopperInfuserScreebHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlerType.COPPER_INFUSER, ModReipeType.INFUSING, RecipeBookCategory.FURNACE, syncId, playerInventory,inventory,propertyDelegate);
    }
}

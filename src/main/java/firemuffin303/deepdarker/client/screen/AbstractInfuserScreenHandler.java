package firemuffin303.deepdarker.client.screen;

import firemuffin303.deepdarker.block.entity.AbstractInfusionBlockEntity;
import firemuffin303.deepdarker.recipe.AbstractInfusingRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public class AbstractInfuserScreenHandler extends AbstractRecipeScreenHandler<Inventory> {
    private static final int input_slots = 3;
    private static final int fuel_slot = 3;
    private static final int output_slot = 4;
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    protected final World world;
    private final RecipeType<? extends AbstractInfusingRecipe> recipeType;
    private final RecipeBookCategory category;

    public AbstractInfuserScreenHandler(ScreenHandlerType<?> screenHandlerType, RecipeType<? extends AbstractInfusingRecipe> recipeType, RecipeBookCategory category, int syncId, PlayerInventory playerInventory) {
        this(screenHandlerType, recipeType,category,syncId,playerInventory,new SimpleInventory(5),new ArrayPropertyDelegate(6));
    }

    protected AbstractInfuserScreenHandler(ScreenHandlerType<?> type, RecipeType<? extends AbstractInfusingRecipe> recipeType, RecipeBookCategory category, int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate){
        super(type,syncId);
        this.recipeType = recipeType;
        this.category = category;
        checkSize(inventory, 5);
        checkDataCount(propertyDelegate, 6);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.world;
        int i;
        for(i = 0;i<input_slots;i++){
            this.addSlot(new Slot(inventory,i,38+i*18,17));
        }
        this.addSlot(new InfuserFuelSlot(this,inventory,fuel_slot,56,53));
        this.addSlot(new InfuserOutputSlot(playerInventory.player, inventory,output_slot,116,35));

        for(i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.addProperties(propertyDelegate);
    }

    @Override
    public void populateRecipeFinder(RecipeMatcher finder) {
        if (this.inventory instanceof RecipeInputProvider) {
            ((RecipeInputProvider)this.inventory).provideRecipeInputs(finder);
        }
    }

    @Override
    public void clearCraftingSlots() {

    }

    @Override
    public boolean matches(Recipe<? super Inventory> recipe) {
        return recipe.matches(this.inventory, this.world);
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return output_slot;
    }

    @Override
    public int getCraftingWidth() {
        return 1;
    }

    @Override
    public int getCraftingHeight() {
        return 1;
    }

    @Override
    public int getCraftingSlotCount() {
        return 5;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return this.category;
    }

    @Override
    public boolean canInsertIntoSlot(int index) {
        return false;
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    protected boolean isFuel(ItemStack itemStack){
        return AbstractInfusionBlockEntity.canUseAsFuel(itemStack);
    }
}

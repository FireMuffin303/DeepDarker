package firemuffin303.deepdarker.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class SculkInfectingRecipe extends AbstractInfusingRecipe {

    public SculkInfectingRecipe(Identifier id, String group, DefaultedList<Ingredient> input, ItemStack output, float experience, int cookTime) {
        super(ModReipeType.SCULK_INFECTING, id, group, input, output, experience, cookTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.SCULK_INFECTING_RECIPE;
    }


}

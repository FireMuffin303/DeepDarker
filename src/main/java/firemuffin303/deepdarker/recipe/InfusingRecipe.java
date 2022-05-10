package firemuffin303.deepdarker.recipe;

import firemuffin303.deepdarker.block.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class InfusingRecipe extends AbstractInfusingRecipe {

    public InfusingRecipe(Identifier id,String group, DefaultedList<Ingredient> input, ItemStack output, float experience, int infusionTime){
        super(ModReipeType.INFUSING,id,group,input,output,experience,infusionTime);
    }

    @Override
    public ItemStack createIcon(){return new ItemStack(ModBlocks.COPPER_INFUSER);}

    @Override
    public RecipeSerializer<?> getSerializer(){return ModRecipeSerializer.INFUSING_RECIPE; }
}

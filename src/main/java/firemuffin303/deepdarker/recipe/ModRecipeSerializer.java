package firemuffin303.deepdarker.recipe;

import firemuffin303.deepdarker.DeepDarker;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipeSerializer <T extends Recipe<?>>{
    public static InfusionRecipeSerializer<InfusingRecipe> INFUSING_RECIPE;
    public static InfusionRecipeSerializer<SculkInfectingRecipe> SCULK_INFECTING_RECIPE;

    public static void init(){
        INFUSING_RECIPE = Registry.register(Registry.RECIPE_SERIALIZER,new Identifier(DeepDarker.MODID,"infusing"),INFUSING_RECIPE);
        SCULK_INFECTING_RECIPE = Registry.register(Registry.RECIPE_SERIALIZER,new Identifier(DeepDarker.MODID,"sculk_infector"),SCULK_INFECTING_RECIPE);
    }
}

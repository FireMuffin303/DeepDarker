package firemuffin303.deepdarker.recipe;

import firemuffin303.deepdarker.DeepDarker;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModReipeType<T extends Recipe<?>> {
    public static RecipeType<InfusingRecipe> INFUSING;
    public static RecipeType<SculkInfectingRecipe> SCULK_INFECTING;

    public static void init(){
        INFUSING =  Registry.register(Registry.RECIPE_TYPE,new Identifier(DeepDarker.MODID,"infusing"),INFUSING);
        SCULK_INFECTING = Registry.register(Registry.RECIPE_TYPE,new Identifier(DeepDarker.MODID,"sculk_infecting"),SCULK_INFECTING);
    }

}

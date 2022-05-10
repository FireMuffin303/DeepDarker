package firemuffin303.deepdarker.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

public class InfusionRecipeSerializer<T extends AbstractInfusingRecipe> implements RecipeSerializer<T> {
    private final int infusionTime;
    private final RecipeFactory<T> recipeFactory;

    public InfusionRecipeSerializer(RecipeFactory<T> recipeFactory,int infusionTime){
        this.infusionTime = infusionTime;
        this.recipeFactory = recipeFactory;
    }

    @Override
    public T read(Identifier id, JsonObject json) {
        String string = JsonHelper.getString(json,"group","");
        DefaultedList<Ingredient> defaultedList = InfusionRecipeSerializer.getIngredients(JsonHelper.getArray(json,"ingredients"));
        if(defaultedList.isEmpty()){
            throw new JsonParseException("No Ingredients for infusion recipe");
        }
        if (defaultedList.size() > 2){
            throw new JsonParseException("Too many ingredients for infusion recipe");
        }
        String string2 = JsonHelper.asString(json,"result");
        Identifier identifier2 = new Identifier(string2);
        ItemStack result = new ItemStack(Registry.ITEM.getOrEmpty(identifier2).orElseThrow(() -> new IllegalStateException("Item: " + string2 + " does not exist")));
        float experience = JsonHelper.getFloat(json,"experience",0.0f);
        int infusionTime = JsonHelper.getInt(json,"infusionTime",this.infusionTime);
        return recipeFactory.create(id,string,defaultedList,result,experience,infusionTime);
    }

    @Override
    public T read(Identifier id, PacketByteBuf buf) {
        return null;
    }

    @Override
    public void write(PacketByteBuf buf, T recipe) {

    }

    static interface RecipeFactory<T extends AbstractInfusingRecipe>{
        public T create(Identifier var1, String var2, DefaultedList<Ingredient> input, ItemStack result,float experience,int infusionTime);
    }

    private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
        DefaultedList<Ingredient> defaultedList = DefaultedList.of();
        for (int i = 0; i < json.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i));
            if (ingredient.isEmpty()) continue;
            defaultedList.add(ingredient);
        }
        return defaultedList;
    }

}

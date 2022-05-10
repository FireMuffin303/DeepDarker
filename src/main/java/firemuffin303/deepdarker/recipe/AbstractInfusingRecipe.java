package firemuffin303.deepdarker.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public abstract class AbstractInfusingRecipe implements Recipe<Inventory> {
    private final RecipeType<?> type;
    private final String group;
    private final DefaultedList<Ingredient> input;
    private final ItemStack result;
    private final Identifier id;
    private final float experience;
    private final int infusionTime;
    private final int slots = 3;

    public AbstractInfusingRecipe(RecipeType<?> type , Identifier id, String group, DefaultedList<Ingredient> input, ItemStack result, float experience, int infusionTime) {
        this.type = type;
        this.group = group;
        this.id = id;
        this.input = input;
        this.result = result;
        this.experience = experience;
        this.infusionTime = infusionTime;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;
        for (int j = 0; j < slots; ++j) {
            ItemStack itemStack = inventory.getStack(j);
            if (itemStack.isEmpty()) continue;
            ++i;
            recipeMatcher.addInput(itemStack, 1);
        }
        return i == this.input.size() && recipeMatcher.match(this, null);
    }

    @Override
    public ItemStack craft(Inventory inventory) {
        return this.result.copy();
    }


    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return this.result;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    public float getExperience() {
        return this.experience;
    }

    public int getInfusionTime() {
        return this.infusionTime;
    }


    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

}


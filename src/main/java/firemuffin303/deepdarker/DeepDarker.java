package firemuffin303.deepdarker;

import firemuffin303.deepdarker.block.ModBlocks;
import firemuffin303.deepdarker.block.entity.ModBlockEntityType;
import firemuffin303.deepdarker.entity.effect.ModStatusEffects;
import firemuffin303.deepdarker.item.ModItems;
import firemuffin303.deepdarker.potion.ModPotions;
import firemuffin303.deepdarker.recipe.InfusingRecipe;
import firemuffin303.deepdarker.recipe.ModRecipeSerializer;
import firemuffin303.deepdarker.recipe.ModReipeType;
import firemuffin303.deepdarker.recipe.SculkInfectingRecipe;
import firemuffin303.deepdarker.tag.ModBlockTags;
import firemuffin303.deepdarker.tag.ModItemTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;

public class DeepDarker implements ModInitializer {
    public static final String MODID = "deepdarker";

    public static final ItemGroup DEEP_DARKER_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(DeepDarker.MODID,"deepdarker_item_group"),() -> new ItemStack(Blocks.SCULK_CATALYST));


    @Override
    public void onInitialize() {
        ModItems.init();
        ModBlocks.init();
        ModBlockEntityType.init();
        ModReipeType.init();
        ModRecipeSerializer.init();
        ModBlockTags.init();
        ModItemTags.init();
        ModStatusEffects.init();
        ModPotions.init();
    }
}

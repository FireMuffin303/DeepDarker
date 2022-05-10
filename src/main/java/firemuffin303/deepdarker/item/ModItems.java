package firemuffin303.deepdarker.item;

import firemuffin303.deepdarker.DeepDarker;
import firemuffin303.deepdarker.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item SCULK_SOUL_BOTTLE = new Item(new FabricItemSettings().group(DeepDarker.DEEP_DARKER_ITEM_GROUP).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item POTATO_BATTERY = new Item(new FabricItemSettings().group(DeepDarker.DEEP_DARKER_ITEM_GROUP));
    public static final Item CHARGED_POTATO_BATTERY = new ChargedPotatoBatteryItem(new FabricItemSettings().group(DeepDarker.DEEP_DARKER_ITEM_GROUP));
    public static final Item SCULK_GLOW_BERRIES = new AliasedBlockItem(ModBlocks.SCULK_GLOW_BERRIES_VINES, new FabricItemSettings().food(ModFoodComponents.SCULK_GLOW_BERRIES).group(DeepDarker.DEEP_DARKER_ITEM_GROUP));
    public static final Item AMETHYST_SHIELD = new AmethystShieldItem(new FabricItemSettings().group(DeepDarker.DEEP_DARKER_ITEM_GROUP));
    public static final Item ECHO_SHIELD = new EchoShieldItem(new FabricItemSettings().group(DeepDarker.DEEP_DARKER_ITEM_GROUP));

    public static void init(){
        addItem("sculk_soul_bottle",SCULK_SOUL_BOTTLE);
        addItem("potato_battery",POTATO_BATTERY);
        addItem("charged_potato_battery",CHARGED_POTATO_BATTERY);
        addItem("sculk_glow_berries",SCULK_GLOW_BERRIES);
        addItem("amethyst_shield",AMETHYST_SHIELD);
        addItem("echo_shard",ECHO_SHIELD);
    }

    private static void addItem(String id,Item item){
        Registry.register(Registry.ITEM, new Identifier(DeepDarker.MODID,id),item);
    }
}

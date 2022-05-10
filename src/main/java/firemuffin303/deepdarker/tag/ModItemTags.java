package firemuffin303.deepdarker.tag;

import firemuffin303.deepdarker.DeepDarker;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItemTags {
    public static TagKey<Item> SHIELD;

    public static void init(){
        SHIELD = addTag("shield");
    }

    public static TagKey<Item> addTag(String tag){
        return TagKey.of(Registry.ITEM_KEY,new Identifier(DeepDarker.MODID,tag));
    }
}

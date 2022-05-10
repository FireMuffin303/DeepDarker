package firemuffin303.deepdarker.tag;

import com.mojang.datafixers.types.templates.Tag;
import firemuffin303.deepdarker.DeepDarker;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class ModBlockTags {

    public static TagKey<Block> INFUSER;
    public static TagKey<Block> COPPER_INFUSER;
    public static TagKey<Block> SCULK_INFUSER;

    public static void init(){
        INFUSER = addTag("infuser");
        COPPER_INFUSER = addTag("copper_infuser");
        SCULK_INFUSER = addTag("sculk_infuser");
    }

    public static TagKey<Block> addTag(String tag){
        return TagKey.of(Registry.BLOCK_KEY,new Identifier(DeepDarker.MODID,tag));
    }
}

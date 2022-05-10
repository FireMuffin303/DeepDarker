package firemuffin303.deepdarker.block.entity;

import firemuffin303.deepdarker.DeepDarker;
import firemuffin303.deepdarker.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityType {
    public static BlockEntityType<CopperInfuserBlockEntity> COPPER_INFUSER;
    public static BlockEntityType<SculkInfectorBlockEntity> SCULK_INFECTOR;


    public static void init(){
        COPPER_INFUSER = Registry.register(Registry.BLOCK_ENTITY_TYPE, DeepDarker.MODID+":copper_infuser", FabricBlockEntityTypeBuilder.create(CopperInfuserBlockEntity::new, ModBlocks.COPPER_INFUSER).build(null));
        SCULK_INFECTOR = Registry.register(Registry.BLOCK_ENTITY_TYPE, DeepDarker.MODID+":sculk_infector", FabricBlockEntityTypeBuilder.create(SculkInfectorBlockEntity::new, ModBlocks.SCULK_INFESTOR).build(null));
    }

}

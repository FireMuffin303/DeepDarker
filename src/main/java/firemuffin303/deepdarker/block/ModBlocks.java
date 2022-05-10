package firemuffin303.deepdarker.block;

import firemuffin303.deepdarker.DeepDarker;
import firemuffin303.deepdarker.state.ModProperties;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final Block SCULK_INFESTOR;
    public static final Block COPPER_INFUSER;
    public static final Block EXPOSED_COPPER_INFUSER;
    public static final Block WEATHERED_COPPER_INFUSER;
    public static final Block OXIDIZED_COPPER_INFUSER;

    public static final Block SCULK_PLANKS;
    public static final Block SCULK_LOG;
    public static final Block STRIPPED_SCULK_LOG;
    public static final Block SCULK_WOOD;
    public static final Block STRIPPED_SCULK_WOOD;
    public static final Block SCULK_STAIRS;
    public static final Block SCULK_DOOR;
    public static final Block SCULK_PRESSURE_PLATE;
    public static final Block SCULK_FENCE;
    public static final Block SCULK_TRAPDOOR;
    public static final Block SCULK_FENCE_GATE;
    public static final Block SCULK_BUTTON;
    public static final Block SCULK_SLAB;
    public static final Block SCULK_ROOTS;
    public static final Block SCULK_VEINS_ROOTS;
    public static final Block SCULK_GLOW_BERRIES_VINES;
    public static final Block SCULK_GLOW_BERRIES_VINES_PLANT;

    public static void init(){
      addBlock("sculk_infestor", SCULK_INFESTOR);
      addBlock("copper_infuser",COPPER_INFUSER);
      addBlock("exposed_copper_infuser",EXPOSED_COPPER_INFUSER);
      addBlock("weathered_copper_infuser",WEATHERED_COPPER_INFUSER);
      addBlock("oxidized_copper_infuser",OXIDIZED_COPPER_INFUSER);

        //Sculk Wood
        addBlock("sculk_planks",SCULK_PLANKS);
        addBlock("sculk_log",SCULK_LOG);
        addBlock("stripped_sculk_log",STRIPPED_SCULK_LOG);
        addBlock("sculk_wood",SCULK_WOOD);
        addBlock("stripped_sculk_wood",STRIPPED_SCULK_WOOD);
        addBlock("sculk_stair",SCULK_STAIRS);
        addBlock("sculk_door",SCULK_DOOR);
        addBlock("sculk_pressure_plate",SCULK_PRESSURE_PLATE);
        addBlock("sculk_fence",SCULK_FENCE);
        addBlock("sculk_trapdoor",SCULK_TRAPDOOR);
        addBlock("sculk_fence_gate",SCULK_FENCE_GATE);
        addBlock("sculk_button",SCULK_BUTTON);
        addBlock("sculk_slab",SCULK_SLAB);
        addBlock("sculk_roots",SCULK_ROOTS);
        addBlock("sculk_veins_roots",SCULK_VEINS_ROOTS);

        Registry.register(Registry.BLOCK, new Identifier(DeepDarker.MODID,"sculk_berries_vine"),SCULK_GLOW_BERRIES_VINES);
        Registry.register(Registry.BLOCK,new Identifier(DeepDarker.MODID,"sculk_berries_vine_plant"),SCULK_GLOW_BERRIES_VINES_PLANT);
    }

    private static void addBlock(String id,Block block){
        Registry.register(Registry.BLOCK, new Identifier(DeepDarker.MODID,id),block);
        Registry.register(Registry.ITEM, new Identifier(DeepDarker.MODID,id),new BlockItem(block,new FabricItemSettings().group(DeepDarker.DEEP_DARKER_ITEM_GROUP)));
    }

    private static PillarBlock createLogBlock(MapColor mapColor,float hardness,float resistance,BlockSoundGroup blockSoundGroup){
        return new PillarBlock(FabricBlockSettings.of(Material.WOOD,mapColor).strength(hardness,resistance).sounds(blockSoundGroup));
    }

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean)state.get(Properties.LIT) ? litLevel : 0;
    }

    private static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    static{
        SCULK_INFESTOR =  new SculkInfestorBlock(FabricBlockSettings.of(Material.SCULK).strength(3.0f,3.0f).sounds(BlockSoundGroup.SCULK_SHRIEKER).requiresTool());
        COPPER_INFUSER = new CopperInfuser(Oxidizable.OxidationLevel.UNAFFECTED,FabricBlockSettings.of(Material.METAL).strength(3.0f,6.0f).requiresTool().sounds(BlockSoundGroup.COPPER).requiresTool());
        EXPOSED_COPPER_INFUSER = new CopperInfuser(Oxidizable.OxidationLevel.EXPOSED,FabricBlockSettings.of(Material.METAL).strength(3.0f,6.0f).requiresTool().sounds(BlockSoundGroup.COPPER).requiresTool());
        WEATHERED_COPPER_INFUSER = new CopperInfuser(Oxidizable.OxidationLevel.WEATHERED,FabricBlockSettings.of(Material.METAL).strength(3.0f,6.0f).requiresTool().sounds(BlockSoundGroup.COPPER).requiresTool());
        OXIDIZED_COPPER_INFUSER = new CopperInfuser(Oxidizable.OxidationLevel.OXIDIZED,FabricBlockSettings.of(Material.METAL).strength(3.0f,6.0f).requiresTool().sounds(BlockSoundGroup.COPPER).requiresTool());

        //SCULK WOOD
        SCULK_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.TEAL).strength(2.0f,2.0f).sounds(BlockSoundGroup.NETHER_STEM));
        SCULK_LOG = createLogBlock(MapColor.DARK_AQUA,2.0f,2.0f,BlockSoundGroup.NETHER_STEM);
        STRIPPED_SCULK_LOG = createLogBlock(MapColor.DARK_AQUA,2.0f,2.0f,BlockSoundGroup.NETHER_STEM);
        SCULK_WOOD = createLogBlock(MapColor.DARK_AQUA,2.0f,2.0f,BlockSoundGroup.NETHER_STEM);
        STRIPPED_SCULK_WOOD = createLogBlock(MapColor.DARK_AQUA,2.0f,2.0f,BlockSoundGroup.NETHER_STEM);
        SCULK_STAIRS = createLogBlock(MapColor.TEAL,2.0f,2.0f,BlockSoundGroup.NETHER_STEM);
        SCULK_DOOR = new DoorBlock(FabricBlockSettings.of(Material.WOOD,MapColor.BRIGHT_TEAL).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque());
        SCULK_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,FabricBlockSettings.of(Material.WOOD,MapColor.BRIGHT_TEAL).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD));
        SCULK_FENCE = new FenceBlock(FabricBlockSettings.of(Material.WOOD,MapColor.BRIGHT_TEAL).strength(2.0f,3.0f).sounds(BlockSoundGroup.WOOD));
        SCULK_TRAPDOOR = new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD,MapColor.BRIGHT_TEAL).strength(3.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().allowsSpawning(ModBlocks::never));
        SCULK_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD,MapColor.BRIGHT_TEAL).strength(2.0f,3.0f).sounds(BlockSoundGroup.WOOD));
        SCULK_BUTTON = new WoodenButtonBlock(FabricBlockSettings.of(Material.DECORATION).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOD));
        SCULK_SLAB = new SlabBlock(FabricBlockSettings.of(Material.WOOD,MapColor.BRIGHT_TEAL).strength(2.0f,3.0f).sounds(BlockSoundGroup.WOOD));
        SCULK_ROOTS = new MangroveRootsBlock(FabricBlockSettings.of(Material.WOOD,MapColor.DARK_AQUA).strength(0.7f).ticksRandomly().sounds(BlockSoundGroup.NETHER_STEM).nonOpaque());
        SCULK_VEINS_ROOTS =new PillarBlock(FabricBlockSettings.of(Material.SCULK,MapColor.DARK_AQUA).strength(0.7f).sounds(BlockSoundGroup.SCULK));

        SCULK_GLOW_BERRIES_VINES = new SculkGlowBerriesVineHeadBlock(FabricBlockSettings.of(Material.PLANT).ticksRandomly().noCollision().luminance(ModCaveVines.getLuminanceSupplier(8)).breakInstantly().sounds(BlockSoundGroup.CAVE_VINES));
        SCULK_GLOW_BERRIES_VINES_PLANT = new SculkGlowBerriesVineBodyBlock(FabricBlockSettings.copyOf(SCULK_GLOW_BERRIES_VINES));

    }
}

package firemuffin303.deepdarker.block;

import firemuffin303.deepdarker.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.AbstractRandom;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SculkGlowBerriesVineHeadBlock extends AbstractPlantStemBlock implements Fertilizable, ModCaveVines {
    private static final float GROW_CHANCE = 0.11F;
    protected SculkGlowBerriesVineHeadBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1D);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0)).with(BERRIES, false));
    }

    @Override
    protected int getGrowthLength(AbstractRandom random) {
        return 1;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return state.isAir();
    }

    protected BlockState copyState(BlockState from, BlockState to) {
        return (BlockState)to.with(BERRIES, (Boolean)from.get(BERRIES));
    }

    @Override
    protected Block getPlant() {
        return ModBlocks.SCULK_GLOW_BERRIES_VINES_PLANT;
    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.SCULK_GLOW_BERRIES);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ModCaveVines.pickBerries(state, world, pos,new ItemStack(ModItems.SCULK_GLOW_BERRIES));
    }

    protected BlockState age(BlockState state, AbstractRandom random) {
        return (BlockState)super.age(state, random).with(BERRIES, random.nextFloat() < 0.11F);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{BERRIES});
    }

    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return !(Boolean)state.get(BERRIES);
    }

    public boolean canGrow(World world, AbstractRandom random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, AbstractRandom random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, (BlockState)state.with(BERRIES, true), 2);
    }
}

package firemuffin303.deepdarker.block;

import firemuffin303.deepdarker.block.entity.SculkInfectorBlockEntity;
import firemuffin303.deepdarker.recipe.SculkInfectingRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SculkInfestorBlock extends AbstractInfuserBlock {

    public SculkInfestorBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SculkInfectorBlockEntity(pos,state);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof SculkInfectorBlockEntity){
            SculkInfectorBlockEntity sculkInfectorBlockEntity = (SculkInfectorBlockEntity) blockEntity;
            ItemStack itemStack = player.getStackInHand(hand);
            Optional<SculkInfectingRecipe> optional = sculkInfectorBlockEntity.getRecipeFor(itemStack);
        }
        return ActionResult.PASS;
    }


}

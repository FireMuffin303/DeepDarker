package firemuffin303.deepdarker.block;

import firemuffin303.deepdarker.block.entity.CopperInfuserBlockEntity;
import firemuffin303.deepdarker.recipe.InfusingRecipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.AbstractRandom;
import net.minecraft.world.World;

import java.util.Optional;

public class CopperInfuser extends AbstractInfuserBlock implements Oxidizable {
    private final Oxidizable.OxidationLevel oxidationLevel;

    public CopperInfuser(Oxidizable.OxidationLevel oxidationLevel, Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }


    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, AbstractRandom random){
        this.tickDegradation(state,world,pos,random);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand ,BlockHitResult hit){
        ItemStack itemStack;
        CopperInfuserBlockEntity copperInfuserEntity;
        Optional<InfusingRecipe> optional;
        BlockEntity blockEntity = world.getBlockEntity(pos);
       /* if(blockEntity instanceof CopperInfuserBlockEntity &&(optional = (copperInfuserEntity = (CopperInfuserBlockEntity)blockEntity).getRecipeFor(itemStack = player.getStackInHand(hand))).isPresent()){

        }*/
        return  ActionResult.PASS;
    }
}
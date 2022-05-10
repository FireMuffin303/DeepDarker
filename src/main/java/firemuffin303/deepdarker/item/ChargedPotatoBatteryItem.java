package firemuffin303.deepdarker.item;

import firemuffin303.deepdarker.block.CopperInfuser;
import firemuffin303.deepdarker.block.ModBlocks;
import firemuffin303.deepdarker.tag.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ChargedPotatoBatteryItem extends Item {
    public ChargedPotatoBatteryItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();
        BlockState blockState = world.getBlockState(blockPos);

        if(context.getSide() != Direction.DOWN && blockState.isIn(ModBlockTags.COPPER_INFUSER)&& !blockState.get(Properties.LIT)){
            playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(Items.GLASS_BOTTLE)));
            world.playSound(playerEntity,blockPos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.NEUTRAL,1.0f,1.0f);
            world.setBlockState(blockPos,blockState.with(Properties.LIT,true),11);
            ActionResult.success(world.isClient);
        }
        return ActionResult.FAIL;
    }
}

package firemuffin303.deepdarker.mixin;

import firemuffin303.deepdarker.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.state.property.Properties.CAN_SUMMON;
import static net.minecraft.state.property.Properties.SHRIEKING;


@Mixin(GlassBottleItem.class)
public class GlassBottleItemMixin extends Item {
    public GlassBottleItemMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "use",at = @At("TAIL"),cancellable = true)
    public void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack itemStack = user.getStackInHand(hand);
        HitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = ((BlockHitResult)hitResult).getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);
            if(blockState.isOf(Blocks.SCULK_SHRIEKER) && blockState.get(CAN_SUMMON)){
                world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                user.getItemCooldownManager().set(this, 10);
                cir.setReturnValue(TypedActionResult.success(ItemUsage.exchangeStack(itemStack, user,new ItemStack(ModItems.SCULK_SOUL_BOTTLE)),true));
                if(world.random.nextInt(10) <= 5 && !user.isSneaking()){
                    if(world instanceof ServerWorld){
                        ServerWorld serverWorld = (ServerWorld)world;
                        serverWorld.getBlockEntity(blockPos, BlockEntityType.SCULK_SHRIEKER).ifPresent((blockEntity) -> {
                            blockEntity.shriek(serverWorld,user);
                        });
                    }
                }
            }
        }
    }

}

package firemuffin303.deepdarker.mixin;

import com.mojang.authlib.GameProfile;
import firemuffin303.deepdarker.item.ModItems;
import firemuffin303.deepdarker.tag.ModItemTags;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Arm;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin extends LivingEntity {
    private final ItemCooldownManager itemCooldownManager;
    protected PlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
        super(EntityType.PLAYER, world);
        this.itemCooldownManager = this.createCooldownManager();
    }

    protected ItemCooldownManager createCooldownManager() {
        return new ItemCooldownManager();
    }

    public ItemCooldownManager getItemCooldownManager() {
        return this.itemCooldownManager;
    }
    @Inject(method = "disableShield",at = @At("TAIL"),cancellable = true)
    public void disableShield(boolean sprinting, CallbackInfo ci) {
        float f = 0.25F + (float)EnchantmentHelper.getEfficiency(this) * 0.05F;
        if (sprinting) {
            f += 0.75F;
        }

        if (this.random.nextFloat() < f) {
            this.getItemCooldownManager().set(ModItems.AMETHYST_SHIELD, 100);
            this.getItemCooldownManager().set(ModItems.ECHO_SHIELD, 100);
            this.clearActiveItem();
            this.world.sendEntityStatus(this, (byte)30);
        }
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return null;
    }
}

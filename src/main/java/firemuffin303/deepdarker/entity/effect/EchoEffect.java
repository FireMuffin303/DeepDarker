package firemuffin303.deepdarker.entity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class EchoEffect extends StatusEffect {
    protected EchoEffect() {
        super(StatusEffectCategory.NEUTRAL, 3824237);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration,int amplifier){
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExperience(1 << amplifier);
        }
    }
}

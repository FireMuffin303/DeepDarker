package firemuffin303.deepdarker.potion;

import firemuffin303.deepdarker.entity.effect.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static final Potion ECHO = new Potion(new StatusEffectInstance[]{new StatusEffectInstance(ModStatusEffects.ECHO,3600)});
    public static final Potion LONG_ECHO = new Potion("echo",new StatusEffectInstance[]{new StatusEffectInstance(ModStatusEffects.ECHO,9600)});
    public static final Potion STRONG_ECHO = new Potion("echo",new StatusEffectInstance[]{new StatusEffectInstance(ModStatusEffects.ECHO,1800,1)});

    public static void init(){
        addPotion("echo",ECHO);
        addPotion("long_echo",LONG_ECHO);
        addPotion("strong_echo",STRONG_ECHO);
    }

    public static void addPotion(String id,Potion potion){
        Registry.register(Registry.POTION,id,potion);
    }
}

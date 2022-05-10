package firemuffin303.deepdarker.entity.effect;

import firemuffin303.deepdarker.DeepDarker;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {
    public static final StatusEffect RAW_ECHO = new EchoEffect();
    public static final StatusEffect ECHO = new EchoEffect();

    public static void init(){
        Registry.register(Registry.STATUS_EFFECT,new Identifier(DeepDarker.MODID,"raw_echo"),RAW_ECHO);
        Registry.register(Registry.STATUS_EFFECT,new Identifier(DeepDarker.MODID,"echo"),ECHO);
    }
}

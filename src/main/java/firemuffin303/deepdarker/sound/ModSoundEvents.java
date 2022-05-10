package firemuffin303.deepdarker.sound;

import firemuffin303.deepdarker.DeepDarker;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {
    public static final SoundEvent MUSIC_OVERWORLD_LUSH_DEEP_DARK = register("music.overworld.lush_deep_dark");

    private static SoundEvent register(String id) {
        return (SoundEvent) Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(new Identifier(DeepDarker.MODID,id)));
    }
}

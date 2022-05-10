package firemuffin303.deepdarker.client.screen;

import firemuffin303.deepdarker.DeepDarker;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlerType<T extends ScreenHandler> {
    public static final ScreenHandlerType<CopperInfuserScreebHandler> COPPER_INFUSER = new ScreenHandlerType<>(CopperInfuserScreebHandler::new);
    public static final ScreenHandlerType<SculkInfectorScreenHandler> SCULK_INFECTOR = new ScreenHandlerType<>(SculkInfectorScreenHandler::new);

    public static void init(){
        Registry.register(Registry.SCREEN_HANDLER,new Identifier(DeepDarker.MODID,"infuser"),COPPER_INFUSER);
        Registry.register(Registry.SCREEN_HANDLER,new Identifier(DeepDarker.MODID,"sculk_infector"),SCULK_INFECTOR);
    }


}

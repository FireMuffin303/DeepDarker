package firemuffin303.deepdarker.state;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

public class ModProperties {
    public static final BooleanProperty IS_RIGHT_ITEM;
    public static final BooleanProperty INFUSING;
    public static final IntProperty FUEL_LEVEL;

    static{
        IS_RIGHT_ITEM = BooleanProperty.of("is_right_item");
        INFUSING = BooleanProperty.of("infusing");
        FUEL_LEVEL = IntProperty.of("fuel_level",0,5);

    }
}

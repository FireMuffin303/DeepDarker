package firemuffin303.deepdarker.block.entity;

import com.google.common.collect.Maps;
import firemuffin303.deepdarker.item.ModItems;
import firemuffin303.deepdarker.recipe.ModReipeType;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class SculkInfectorBlockEntity extends AbstractInfusionBlockEntity {

    public SculkInfectorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.SCULK_INFECTOR, pos, state, ModReipeType.SCULK_INFECTING);
    }

    public static @NotNull Map<Item,Integer> createFuelTimeMap(){
        Map<Item,Integer> map = Maps.newLinkedHashMap();
        map.put(ModItems.SCULK_SOUL_BOTTLE,6000);
        map.put(Items.SOUL_SAND,800);
        map.put(Items.SOUL_SOIL,400);
        return map;
    }

    protected Text getContainerName() {
        return Text.translatable("container.sculk_infector");
    }


}

package firemuffin303.deepdarker.block.entity;

import com.google.common.collect.Maps;
import firemuffin303.deepdarker.item.ModItems;
import firemuffin303.deepdarker.recipe.ModReipeType;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class CopperInfuserBlockEntity extends AbstractInfusionBlockEntity {

    protected CopperInfuserBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityType.COPPER_INFUSER, blockPos, blockState, ModReipeType.INFUSING);
    }

    public static Map<Item, Integer> createFuelTimeMap() {
        Map<Item,Integer> map = Maps.newLinkedHashMap();
        map.put(ModItems.CHARGED_POTATO_BATTERY,3600);
        map.put(Items.REDSTONE_BLOCK,2700);
        map.put(Items.REDSTONE,300);
        return map;
    }

    protected Text getContainerName() {
        return Text.translatable("container.copper_infuser");
    }
}

package joystick.mickey.dees;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {
    public static final FoodComponent RAW_NUGGIE = (new FoodComponent.Builder()).hunger(1).saturationModifier((float) 0.5).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 120, 80), 0.8F).snack().build();
    public static final FoodComponent COOKED_NUGGIE = (new FoodComponent.Builder()).hunger(4).saturationModifier((float) 2.0).snack().build();
}

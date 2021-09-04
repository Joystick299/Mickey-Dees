package joystick.mickey.dees;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {
    public static final FoodComponent RAW_NUGGIE = (new FoodComponent.Builder()).hunger(1).saturationModifier((float) 0.5).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 120, 80), 0.8F).snack().build();
    public static final FoodComponent COOKED_NUGGIE = (new FoodComponent.Builder()).hunger(4).saturationModifier((float) 2.0).snack().build();
    public static final FoodComponent BIG_JON = (new FoodComponent.Builder()).hunger(9).saturationModifier((float) 13.0).build();
    public static final FoodComponent DA_MEAL = (new FoodComponent.Builder()).hunger(10).saturationModifier((float) 13.0).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,125, 100), 0.8F).build();
    public static final FoodComponent RAW_FRENCH_FRIES = (new FoodComponent.Builder()).hunger(1).saturationModifier((float) 3.5).snack().build();
    public static final FoodComponent FRENCH_FRIES = (new FoodComponent.Builder()).hunger(3).saturationModifier((float) 7.5).snack().build();
    public static final FoodComponent STICKS_COOKIES = (new FoodComponent.Builder()).hunger(3).saturationModifier((float) 9.0).snack().build();
    public static final FoodComponent LARGE_FRY = (new FoodComponent.Builder()).hunger(8).saturationModifier((float) 15.5).build();
    public static final FoodComponent DA_PIE = (new FoodComponent.Builder()).hunger(3).saturationModifier((float) 7.0).snack().build();
    public static final FoodComponent DINO_NUGGIE = (new FoodComponent.Builder()).hunger(6).saturationModifier((float) 2.5).build();
}

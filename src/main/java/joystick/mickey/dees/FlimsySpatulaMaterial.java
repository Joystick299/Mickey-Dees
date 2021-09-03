package joystick.mickey.dees;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FlimsySpatulaMaterial implements ToolMaterial{
    public static final FlimsySpatulaMaterial INSTANCE = new FlimsySpatulaMaterial();

    @Override
    public int getDurability() {
        return 250;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return Ingredient.ofItems(Items.IRON_INGOT);
    }

    
}

package joystick.mickey.dees;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CreativeToolMaterial implements ToolMaterial{
    public static final CreativeToolMaterial INSTANCE = new CreativeToolMaterial();

    @Override
    public int getDurability() {
        return 9999;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        // TODO Auto-generated method stub
        return 999;
    }

    @Override
    public float getAttackDamage() {
        // TODO Auto-generated method stub
        return 9999;
    }

    @Override
    public int getMiningLevel() {
        // TODO Auto-generated method stub
        return 9999;
    }

    @Override
    public int getEnchantability() {
        // TODO Auto-generated method stub
        return 9999;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return null;
    }

    
}

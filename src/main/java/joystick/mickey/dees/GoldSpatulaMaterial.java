package joystick.mickey.dees;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GoldSpatulaMaterial implements ToolMaterial{
    public static final GoldSpatulaMaterial INSTANCE = new GoldSpatulaMaterial();

        @Override
        public int getDurability() {
            return 150;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            // TODO Auto-generated method stub
            return 30;
        }

        @Override
        public float getAttackDamage() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int getMiningLevel() {
            // TODO Auto-generated method stub
            return 2;
        }

        @Override
        public int getEnchantability() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public Ingredient getRepairIngredient() {
            // TODO Auto-generated method stub
            return Ingredient.ofItems(Items.GOLD_INGOT);
        }
}

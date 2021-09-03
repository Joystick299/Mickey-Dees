package joystick.mickey.dees;

import net.minecraft.item.PickaxeItem;

public class CustomPickaxeItem extends PickaxeItem {
    public CustomPickaxeItem(CreativeToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public CustomPickaxeItem(FlimsySpatulaMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public CustomPickaxeItem(GoldSpatulaMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public CustomPickaxeItem(DiamondSpatulaMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
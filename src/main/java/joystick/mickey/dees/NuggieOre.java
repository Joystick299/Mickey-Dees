package joystick.mickey.dees;


import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;


public class NuggieOre extends Block{


    public NuggieOre(Settings settings){
        super(settings);
    }
    
    protected int getExperienceWhenMined(Random random){
        return MathHelper.nextInt(random, 0, 5);
    }

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack){
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0){
            int i = this.getExperienceWhenMined(world.random);
            if (i > 0){
                this.dropExperience(world, pos, i);
            }
        }
    }

}

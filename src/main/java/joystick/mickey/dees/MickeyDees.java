package joystick.mickey.dees;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.Feature;

public class MickeyDees implements ModInitializer {
	

	

	public static final Item MICKEY_DEES = new Item(new Item.Settings()); // Dev item

	// Utility 
	// Chnage DA BOX crafting recipe, instead of requiring yellow wool make it require a gold ingot instead 
	public static final Item DA_BOX = new Item(new Item.Settings());


	public static final Block NUGGIE_ORE = new NuggieOre(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	private static ConfiguredFeature<?, ?> NUGGIE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NUGGIE_ORE.getDefaultState(),9)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(120)))).spreadHorizontally().repeat(20);


	// Foods
	// Dino Nuggie
	// Add in a craftable box for the fries so people can make a "large fry" and with 8 french fries, and give a little bonus hunger for the effort
	public static final Item RAW_NUGGIE = new Item(new Item.Settings().food(FoodComponents.RAW_NUGGIE));
	public static final Item COOKED_NUGGIE = new Item(new Item.Settings().food(FoodComponents.COOKED_NUGGIE));
	public static final Item BIG_JON = new Item(new Item.Settings().food(FoodComponents.BIG_JON));
	public static final Item DA_MEAL = new Item(new Item.Settings().food(FoodComponents.DA_MEAL));
	public static final Item RAW_FRENCH_FRIES = new Item(new Item.Settings().food(FoodComponents.RAW_FRENCH_FRIES));
	public static final Item FRENCH_FRIES = new Item(new Item.Settings().food(FoodComponents.FRENCH_FRIES));
	public static final Item STICKS_COOKIES = new Item(new Item.Settings().food(FoodComponents.STICKS_COOKIES));

	// Drinks
	//Caca cola


	// Spatulas
					// material, int attackDamage, float attackSpeed, settings)
	public static ToolItem FLIMSY_SPATULA = new CustomPickaxeItem(FlimsySpatulaMaterial.INSTANCE, 0, 1.0F, new Item.Settings());
	public static ToolItem GOLD_SPATULA = new CustomPickaxeItem(GoldSpatulaMaterial.INSTANCE, 2, 1.0F, new Item.Settings());
	public static ToolItem DIAMOND_SPATULA = new CustomPickaxeItem(DiamondSpatulaMaterial.INSTANCE, 5, 1.0F, new Item.Settings());
	public static ToolItem CREATIVE_SPATULA = new CustomPickaxeItem(CreativeToolMaterial.INSTANCE, 9999, 9999F, new Item.Settings());
	public static final Item GREASY_SPATULA = new Item(new FabricItemSettings().maxCount(1));

	

 
	public static final ItemGroup MICKEY_FOOD = FabricItemGroupBuilder.create(
		new Identifier("mickeydees", "food"))
		.icon(() -> new ItemStack(MickeyDees.BIG_JON))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(MickeyDees.BIG_JON));
			stacks.add(new ItemStack(MickeyDees.COOKED_NUGGIE));
			stacks.add(new ItemStack(MickeyDees.RAW_NUGGIE));
			stacks.add(new ItemStack(MickeyDees.FRENCH_FRIES));
			stacks.add(new ItemStack(MickeyDees.RAW_FRENCH_FRIES));
			stacks.add(new ItemStack(MickeyDees.DA_MEAL));
			// stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
			// stacks.add(ItemStack.EMPTY);
			
		})
		.build();



	public static final ItemGroup MICKEY_SPATULAS = FabricItemGroupBuilder.create(
		new Identifier("mickeydees", "spatulas"))
		.icon(() -> new ItemStack(MickeyDees.GREASY_SPATULA))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(MickeyDees.GREASY_SPATULA));
			stacks.add(new ItemStack(MickeyDees.FLIMSY_SPATULA));
			stacks.add(new ItemStack(MickeyDees.GOLD_SPATULA));
			stacks.add(new ItemStack(MickeyDees.DIAMOND_SPATULA));
			stacks.add(new ItemStack(MickeyDees.CREATIVE_SPATULA));
		})
		.build();

	public static final ItemGroup MICKEY_ORE = FabricItemGroupBuilder.create(
		new Identifier("mickeydees", "ore"))
		.icon(() -> new ItemStack(MickeyDees.NUGGIE_ORE))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(MickeyDees.NUGGIE_ORE));
		})
		.build();

	public static final ItemGroup MICKEY_MISC = FabricItemGroupBuilder.create(
		new Identifier("mickeydees", "misc"))
		.icon(() -> new ItemStack(MickeyDees.DA_BOX))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(MickeyDees.DA_BOX));
		})
		.build();

	


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		Registry.register(Registry.ITEM, new Identifier("mickeydees", "mickey_dees"), MICKEY_DEES);
		Registry.register(Registry.BLOCK, new Identifier("mickeydees", "nuggie_ore"), NUGGIE_ORE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "nuggie_ore"), new BlockItem(NUGGIE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "da_box"), DA_BOX);


		// Foods
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "raw_nuggie"), RAW_NUGGIE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "big_jon"), BIG_JON);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "da_meal"), DA_MEAL);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "cooked_nuggie"), COOKED_NUGGIE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "raw_french_fries"), RAW_FRENCH_FRIES);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "french_fries"), FRENCH_FRIES);


		// Spatulas
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "flimsy_spatula"), FLIMSY_SPATULA);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "gold_spatula"), GOLD_SPATULA);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "diamond_spatula"), DIAMOND_SPATULA);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "greasy_spatula"), GREASY_SPATULA);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "creative_spatula"), CREATIVE_SPATULA);


		RegistryKey<ConfiguredFeature<?, ?>> nuggieOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("mickeydees", "nuggie_ore"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, nuggieOreOverworld.getValue(), NUGGIE_ORE_OVERWORLD);
		// BiomeModifications is not supported right now, so it identifies as deprecated.
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, nuggieOreOverworld);
	}
}
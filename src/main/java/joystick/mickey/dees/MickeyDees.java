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
	public static final Item DA_BOX = new Item(new Item.Settings());
	public static final Item FRY_BOX = new Item(new Item.Settings());
	public static final Item DINO_STENCIL = new Item(new Item.Settings());
	public static final Item DA_TOY = new Item(new Item.Settings());


	public static final Block NUGGIE_ORE = new NuggieOre(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	private static ConfiguredFeature<?, ?> NUGGIE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, NUGGIE_ORE.getDefaultState(),9)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(120)))).spreadHorizontally().repeat(20);

	public static final Block BARBEQUE_ORE = new BarbequeOre(FabricBlockSettings.of(Material.STONE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	private static ConfiguredFeature<?, ?> BARBEQUE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BARBEQUE_ORE.getDefaultState(),9)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(120)))).spreadHorizontally().repeat(20);
	
	public static final Item RAW_BBQ = new Item(new Item.Settings());

	// Foods

	// Add in a craftable box for the fries so people can make a "large fry" and with 8 french fries, and give a little bonus hunger for the effort
	public static final Item RAW_NUGGIE = new Item(new Item.Settings().food(FoodComponents.RAW_NUGGIE));
	public static final Item COOKED_NUGGIE = new Item(new Item.Settings().food(FoodComponents.COOKED_NUGGIE));
	public static final Item BIG_JON = new Item(new Item.Settings().food(FoodComponents.BIG_JON));
	public static final Item DA_MEAL = new Item(new Item.Settings().food(FoodComponents.DA_MEAL));
	public static final Item RAW_FRENCH_FRIES = new Item(new Item.Settings().food(FoodComponents.RAW_FRENCH_FRIES));
	public static final Item FRENCH_FRIES = new Item(new Item.Settings().food(FoodComponents.FRENCH_FRIES));
	public static final Item STICKS_COOKIES = new Item(new Item.Settings().food(FoodComponents.STICKS_COOKIES));
	public static final Item LARGE_FRY = new Item(new Item.Settings().food(FoodComponents.LARGE_FRY));
	// Texture da_pie and make sure to give it a crafting recipe
	public static final Item DA_PIE = new Item(new Item.Settings().food(FoodComponents.DA_PIE));
	public static final Item RAW_DINO_NUGGIE = new Item(new Item.Settings().food(FoodComponents.RAW_DINO_NUGGIE));
	public static final Item COOKED_DINO_NUGGIE = new Item(new Item.Settings().food(FoodComponents.COOKED_DINO_NUGGIE));

	// Drinks
	//Caca cola


	// Spatulas
					// material, int attackDamage, float attackSpeed, settings)
	public static ToolItem FLIMSY_SPATULA = new CustomPickaxeItem(FlimsySpatulaMaterial.INSTANCE, 0, 1.0F, new Item.Settings());
	public static ToolItem GOLD_SPATULA = new CustomPickaxeItem(GoldSpatulaMaterial.INSTANCE, 2, 1.0F, new Item.Settings());
	public static ToolItem DIAMOND_SPATULA = new CustomPickaxeItem(DiamondSpatulaMaterial.INSTANCE, 5, 1.0F, new Item.Settings());
	public static ToolItem CREATIVE_SPATULA = new CustomPickaxeItem(CreativeToolMaterial.INSTANCE, 9999, 9999F, new Item.Settings());
	public static final Item GREASY_SPATULA = new Item(new FabricItemSettings().maxCount(1));

	





	// Sauces

	public static final Item BBQ_SAUCE = new Item(new Item.Settings());
	public static final Item KETCHUP = new Item(new Item.Settings());
	public static final Item MICKEY_DEES_SAUCE = new Item(new Item.Settings());









 
	public static final ItemGroup MICKEY_FOOD = FabricItemGroupBuilder.create(
		new Identifier("mickeydees", "food"))
		.icon(() -> new ItemStack(MickeyDees.BIG_JON))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(MickeyDees.BIG_JON));
			stacks.add(new ItemStack(MickeyDees.COOKED_NUGGIE));
			stacks.add(new ItemStack(MickeyDees.RAW_NUGGIE));
			stacks.add(new ItemStack(MickeyDees.LARGE_FRY));
			stacks.add(new ItemStack(MickeyDees.FRENCH_FRIES));
			stacks.add(new ItemStack(MickeyDees.RAW_FRENCH_FRIES));
			stacks.add(new ItemStack(MickeyDees.STICKS_COOKIES));
			stacks.add(new ItemStack(MickeyDees.DA_MEAL));
			stacks.add(new ItemStack(MickeyDees.DA_PIE));
			stacks.add(new ItemStack(MickeyDees.RAW_DINO_NUGGIE));
			stacks.add(new ItemStack(MickeyDees.COOKED_DINO_NUGGIE));
			// stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
			// stacks.add(ItemStack.EMPTY);
			
		})
		.build();

	public static final ItemGroup MICKEY_SAUCE = FabricItemGroupBuilder.create(
		new Identifier("mickeydees", "sauce"))
		.icon(() -> new ItemStack(MickeyDees.BIG_JON))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(MickeyDees.BBQ_SAUCE));
			stacks.add(new ItemStack(MickeyDees.KETCHUP));
			stacks.add(new ItemStack(MickeyDees.MICKEY_DEES_SAUCE));
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
			stacks.add(new ItemStack(MickeyDees.BARBEQUE_ORE));
		})
		.build();

	public static final ItemGroup MICKEY_MISC = FabricItemGroupBuilder.create(
		new Identifier("mickeydees", "misc"))
		.icon(() -> new ItemStack(MickeyDees.DA_BOX))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(MickeyDees.DA_BOX));
			stacks.add(new ItemStack(MickeyDees.FRY_BOX));
			stacks.add(new ItemStack(MickeyDees.DINO_STENCIL));
			stacks.add(new ItemStack(MickeyDees.DA_TOY));
		})
		.build();

	


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		Registry.register(Registry.ITEM, new Identifier("mickeydees", "mickey_dees"), MICKEY_DEES);
		Registry.register(Registry.BLOCK, new Identifier("mickeydees", "nuggie_ore"), NUGGIE_ORE);
		Registry.register(Registry.BLOCK, new Identifier("mickeydees", "barbeque_ore"), BARBEQUE_ORE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "nuggie_ore"), new BlockItem(NUGGIE_ORE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "barbeque_ore"), new BlockItem(BARBEQUE_ORE, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "da_box"), DA_BOX);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "fry_box"), FRY_BOX);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "dino_stencil"), DINO_STENCIL);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "da_toy"), DA_TOY);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "raw_bbq"), RAW_BBQ);


		// Foods
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "raw_nuggie"), RAW_NUGGIE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "big_jon"), BIG_JON);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "da_meal"), DA_MEAL);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "cooked_nuggie"), COOKED_NUGGIE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "raw_french_fries"), RAW_FRENCH_FRIES);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "french_fries"), FRENCH_FRIES);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "sticks_cookies"), STICKS_COOKIES);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "large_fry"), LARGE_FRY);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "da_pie"), DA_PIE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "raw_dino_nuggie"), RAW_DINO_NUGGIE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "cooked_dino_nuggie"), COOKED_DINO_NUGGIE);

		// Sauces
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "bbq_sauce"), BBQ_SAUCE);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "ketchup"), KETCHUP);
		Registry.register(Registry.ITEM, new Identifier("mickeydees", "mickey_dees_sauce"), MICKEY_DEES_SAUCE);


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

		RegistryKey<ConfiguredFeature<?, ?>> barbequeOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("mickeydees", "barbeque_ore"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, barbequeOreOverworld.getValue(), BARBEQUE_ORE_OVERWORLD);
		// BiomeModifications is not supported right now, so it identifies as deprecated.
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, barbequeOreOverworld);
	}
}

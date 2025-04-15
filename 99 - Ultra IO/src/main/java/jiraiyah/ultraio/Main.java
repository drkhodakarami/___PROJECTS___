package jiraiyah.ultraio;

import jiraiyah.jiregister.*;
import jiraiyah.ultraio.registry.*;
import jiraiyah.ultraio.config.Configs;
import net.fabricmc.api.ModInitializer;
import jiraiyah.jilogger.JiLogger;

public class Main implements ModInitializer
{
	public static final String ModID = "ultraio";

	public static final JiLogger LOGGER = new JiLogger(ModID);
	public static final ModReference REFERENCE = new ModReference(ModID);
	public static final Configs CONFIGS = new Configs(ModID);
	public static final JiItemRegister JITEM = new JiItemRegister(ModID);
	public static final JiBlockRegister JBLOCK = new JiBlockRegister(ModID);
	public static final JiBlockItemRegister JBLOCK_ITEM = new JiBlockItemRegister(ModID);
	public static final JiEntityRegister JENTITY = new JiEntityRegister(ModID);
	public static final JiRecipeRegister JRECIPE = new JiRecipeRegister(ModID);
	public static final JiComponentTypeRegister JCOMPONENT_TYPE = new JiComponentTypeRegister(ModID);
	public static final JiStatusEffectRegister JSTATUS_EFFECT = new JiStatusEffectRegister(ModID);
	public static final JiScreenRegister JSCREEN = new JiScreenRegister(ModID);

	@Override
	public void onInitialize()
	{
		LOGGER.logMain();

		CONFIGS.load();

		initializeAll();
	}

	public static void initializeAll()
	{
		ModDataComponentTypes.init();
		ModEvents.init();
		ModArmorMaterials.init();
		ModToolMaterials.init();
		ModItems.init();
		ModBlocks.init();
		ModBlockItems.init();
		ModRecipes.init();
		ModItemGroups.init();
		ModBlockEntities.init();
		ModScreenHandlers.init();
		ModFuels.init();
		ModWorldGeneration.init();
		ModPortals.init();
		ModStrippables.init();
		ModAttributes.init();
		ModCompostables.init();
		ModEffects.init();
		ModFlammables.init();
		ModFuels.init();
		ModOxidizables.init();
		ModPotionRecipes.init();
		ModTrades.init();
		ModCommands.init();
		ModMessages.initC2SPackets();

		ModBlocks.setBlackList();
		ModBlockItems.setBlackList();
		ModItems.setBlackList();
	}
}
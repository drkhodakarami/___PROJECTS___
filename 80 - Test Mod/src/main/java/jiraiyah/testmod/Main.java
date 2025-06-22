package jiraiyah.testmod;

import jiraiyah.jilogger.JiLogger;
import jiraiyah.jiregister.*;
import jiraiyah.testmod.registry.*;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer
{
	public static final String ModID = "testmod";

	public static final JiLogger LOGGER = new JiLogger(ModID);
	public static final ModReference REFERENCE = new ModReference(ModID);
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

		initializeAll();
	}

	public static void initializeAll()
	{
		ModBlocks.init();
		ModBlockItems.init();
		ModItemGroups.init();
		ModBlockEntities.init();
		ModScreenHandlers.init();
	}
}
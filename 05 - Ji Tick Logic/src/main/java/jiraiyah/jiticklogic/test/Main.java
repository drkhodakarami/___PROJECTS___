package jiraiyah.jiticklogic.test;

import jiraiyah.jiticklogic.test.registry.*;
import net.fabricmc.api.ModInitializer;
import jiraiyah.jilogger.JiLogger;

public class Main implements ModInitializer
{
	public static final String ModID = "jiticklogic";

	public static final JiLogger LOGGER = new JiLogger(ModID);
	public static final ModReference REFERENCE = new ModReference(ModID);

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
		ModBlockEntities.init();
		ModItemGroups.init();
	}
}
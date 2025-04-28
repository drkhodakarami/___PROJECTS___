package jiraiyah.jilogger;

import jiraiyah.jibase.annotations.*;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.LoggerFactory;

import static jiraiyah.jibase.constants.LoggerConstants.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class JiLogger
{
    private final org.slf4j.Logger logger;
    private final boolean debug;

    public JiLogger(String modId)
    {
        this.logger = LoggerFactory.getLogger(modId);
        debug = FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    public void logMain()
    {
        this.logger.info("\u001B[38;2;" + 255 + ";" + 255 + ";" + 0 + ";48;2;" + 255 + ";" + 0 + ";" + 127 + "m>>> Initializing {}", RESET);
    }

    public void logItemInit()
    {
        this.log("Registering Items");
    }

    public void logItemGroupInit()
    {
        this.log("Registering Item Groups");
    }

    public void logItemToGroupAdd()
    {
        this.log("Adding Items to Item Groups");
    }

    public void logBlockInit()
    {
        this.log("Registering Blocks");
    }

    public void logBlockToGroupAdd()
    {
        this.log("Adding Blocks to Item Groups");
    }

    public void logBlockItemInit()
    {
        this.log("Registering Block Items");
    }

    public void logGameRuleInit()
    {
        this.log("Registering Game Rules");
    }

    public void logBlockEntityInit()
    {
        this.log("Registering Block Entities");
    }

    public void logCommandInit()
    {
        this.log("Registering Commands");
    }

    public void logEventInit()
    {
        this.log("Registering Events");
    }

    public void logC2SInit()
    {
        this.log("Registering C2S Messages");
    }

    public void logS2CInit()
    {
        this.log("Registering S2C Messages");
    }

    public void logMessageSendClient()
    {
        this.log("Sending a message to client player entities.");
    }

    public void logRecipeInit()
    {
        this.log("Registering Recipes");
    }

    public void logScreenHandlerInit()
    {
        this.log("Registering Screen Handlers");
    }

    public void logWorldGenerationInit()
    {
        this.log("Registering World Generation");
    }

    public void logTreeGenerationInit()
    {
        this.log("Registering Tree Data");
    }

    public void logOreGenerationInit()
    {
        this.log("Registering Ore Data");
    }

    public void logGeodeGenerationInit()
    {
        this.log("Registering Geode Data");
    }

    public void logFlowerGenerationInit()
    {
        this.log("Registering Flower Data");
    }

    public void logEntitySpawnInit()
    {
        this.log("Registering Entity Spawn Data");
    }

    public void logTradeInit()
    {
        this.log("Registering Custom Trades");
    }

    public void logToolMaterialInit()
    {
        this.log("Registering Tool Materials");
    }

    public void logStrippablesInit()
    {
        this.log("Registering Strippables");
    }

    public void logPotionRecipeInit()
    {
        this.log("Registering Potion Recipes");
    }

    public void logPortalInit()
    {
        this.log("Registering Custom Portals");
    }

    public void logOxidizableInit()
    {
        this.log("Registering Oxidizables");
    }

    public void logModelPredicateInit()
    {
        this.log("Registering Model Predicates");
    }

    public void logFuelInit()
    {
        this.log("Registering Fuel");
    }

    public void logFlammablesInit()
    {
        this.log("Registering Flammables");
    }

    public void logEffectInit()
    {
        this.log("Registering Effects");
    }

    public void logDataComponentInit()
    {
        this.log("Registering custom data component types");
    }

    public void logCompostablesInit()
    {
        this.log("Registering Compostables");
    }

    public void logAttributeInit()
    {
        this.log("Registering Attributes");
    }

    public void logArmorMaterialInit()
    {
        this.log("Registering Armor Materials");
    }

    public void logClient()
    {
        this.logger.info("\u001B[38;2;" + 0 + ";" + 255 + ";" + 255 + ";48;2;" + 0 + ";" + 155 + ";" + 55 + "m>>> Initializing client side {}", RESET);
    }

    public void logDatagen()
    {
        this.logger.info("\u001B[38;2;" + 255 + ";" + 255 + ";" + 0 + ";48;2;" + 0 + ";" + 155 + ";" + 55 + "m>>> Generating Data {}", RESET);
    }

    public void logDatageFeatures()
    {
        this.logG("Registering Data Generation Features");
    }

    public void logRecipeDatagen()
    {
        this.logG("Generating Recipe Data");
    }

    public void logBlockModelDatagen()
    {
        this.logG("Generating Block Model Data");
    }

    public void logItemModelDatagen()
    {
        this.logG("Generating Item Model Data");
    }

    public void logLootTableDatagen()
    {
        this.logG("Generating Loot Table Data");
    }

    public void logItemTagDatagen()
    {
        this.logG("Generating Item Tag Data");
    }

    public void logEntityTagDatagen()
    {
        this.logG("Generating Entity Tag Data");
    }

    public void logEnLanguageDatagen()
    {
        this.logG("Generating en_us Language Data");
    }

    public void logBlockTagDatagen()
    {
        this.logG("Generating Block Tag Data");
    }

    public void logWorldGeneratorDatagen()
    {
        this.logG("Generating World Features Data");
    }

    public void logPlacedDatagenBootstrap()
    {
        this.logG("Generating Placed Features Data");
    }

    public void logFeaturesDatagenBootstrap()
    {
        this.logG("Generating Configured Features Data");
    }

    public void log(String message)
    {
        if (this.debug)
            log(message, Foreground.BRIGHT_MAGENTA);
    }

    public void logR(String message)
    {
        if (this.debug)
            log(message, 255, 0, 0);
    }

    public void logG(String message)
    {
        if (this.debug)
            log(message, 0, 255, 0);
    }

    public void logB(String message)
    {
        if (this.debug)
            log(message, 0, 0, 255);
    }

    public void log(String message, String foreground)
    {
        this.logger.info("{}>>> {}" + RESET, foreground, message);
    }

    public void log(String message, String foreground, String background)
    {
        this.logger.info("{}{}>>> {}" + RESET, background, foreground, message);
    }

    public void log(String message, int r, int g, int b)
    {
        if (this.debug)
            this.logger.info("\u001B[38;2;{};{};{}m>>> {}" + RESET, r, g, b, message);
    }

    public void log(String message, int rf, int gf, int bf, int rb, int gb, int bb)
    {
        if (this.debug)
            this.logger.info("\u001B[38;2;{};{};{};48;2;{};{};{}m>>> {} " + RESET, rf, gf, bf, rb, gb, bb, message);
    }

    public void logError(String message)
    {
        logError(message, false);
    }

    public void logError(String message, boolean customColor)
    {
        if (customColor)
            logError(message, Foreground.BLACK, Background.BRIGHT_RED);
        else
        {
            this.logger.error(message);
            this.logger.trace(message);
        }
    }

    public void logError(String message, String foreground)
    {
        this.logger.error("{}>>> {}" + RESET, foreground, message);
        this.logger.trace(message);
    }

    public void logError(String message, String foreground, String background)
    {
        this.logger.error("{}{}>>> {}" + RESET, background, foreground, message);
        this.logger.trace(message);
    }

    public void logWarning(String message)
    {
        logWarning(message, false);
    }

    public void logWarning(String message, boolean customColor)
    {
        if (this.debug)
        {
            if (customColor)
                logWarning(message, Foreground.BLACK, Background.BRIGHT_YELLOW);
            else
                this.logger.warn(message);
        }
    }

    public void logWarning(String message, String foreground)
    {
        if (this.debug)
            this.logger.warn("{}>>> {}" + RESET, foreground, message);
    }

    public void logWarning(String message, String foreground, String background)
    {
        if (this.debug)
            this.logger.warn("{}{}>>> {}" + RESET, background, foreground, message);
    }

    public void logN(String message)
    {
        if (this.debug)
            this.logger.info(">>> {}", message);
    }
}
package jiraiyah.jilogger;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.LoggerFactory;

import static jiraiyah.jilogger.LoggerConstants.*;

@SuppressWarnings({"unused"})
public class JiLogger
{
    private final org.slf4j.Logger logger;
    private final boolean debug;

    public JiLogger(String modId)
    {
        this.logger = LoggerFactory.getLogger(modId);
        debug = FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    /**
     * Logs the initialization message of the mod to the console.
     * This method uses a specific ANSI color formatting for the log message
     * to enhance visibility. It outputs an info level log indicating
     * that the mod is being initialized. The colors are set to a
     * bright-yellow foreground with a pink background for emphasis.
     */
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

    /**
     * Logs the initialization message of the datagen to the console.
     * This method uses a specific ANSI color formatting for the log message
     * to enhance visibility. It outputs an info level log indicating
     * that the mod is being initialized. The colors are set to a
     * bright-yellow foreground with a green background for emphasis.
     */
    public void logDatagen()
    {
        this.logger.info("\u001B[38;2;" + 255 + ";" + 255 + ";" + 0 + ";48;2;" + 0 + ";" + 155 + ";" + 55 + "m>>> Generating Data {}", RESET);
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

    /**
     * Logs a message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * message using an info level log. The message is formatted with
     * bright magenta text to enhance visibility in the console output.
     *
     * @param message The message to log, intended for debugging purposes.
     */
    public void log(String message)
    {
        if (this.debug)
            log(message, Foreground.BRIGHT_MAGENTA);
    }

    /**
     * Logs a message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * message using an info level log. The message is formatted with
     * red text to enhance visibility in the console output.
     *
     * @param message The message to log, intended for debugging purposes.
     */
    public void logR(String message)
    {
        if (this.debug)
            log(message, 255, 0, 0);
    }

    /**
     * Logs a message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * message using an info level log. The message is formatted with
     * green text to enhance visibility in the console output.
     *
     * @param message The message to log, intended for debugging purposes.
     */
    public void logG(String message)
    {
        if (this.debug)
            log(message, 0, 255, 0);
    }

    /**
     * Logs a message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * message using an info level log. The message is formatted with
     * blue text to enhance visibility in the console output.
     *
     * @param message The message to log, intended for debugging purposes.
     */
    public void logB(String message)
    {
        if (this.debug)
            log(message, 0, 0, 255);
    }

    /**
     * Logs a message with a specified foreground color.
     *
     * @param message    The message to be logged.
     * @param foreground The color to be used for the text of the message.
     */
    public void log(String message, String foreground)
    {
        this.logger.info("{}>>> {}" + RESET, foreground, message);
    }

    /**
     * Logs a message with specified foreground and background colors.
     *
     * @param message    The message to be logged.
     * @param foreground The color to be used for the text of the message.
     * @param background The color to be used for the background of the message.
     */
    public void log(String message, String foreground, String background)
    {
        this.logger.info("{}{}>>> {}" + RESET, background, foreground, message);
    }

    /**
     * Logs a message to the console with customizable RGB color formatting
     * if debugging is enabled. This method allows the user to specify
     * the red, green, and blue color components for the message text.
     * The output will use the specified RGB values for the text color,
     * making it easier to highlight messages in a colorful manner.
     *
     * @param message The message to log, intended for informational output.
     * @param r       The red component of the text color (0-255).
     * @param g       The green component of the text color (0-255).
     * @param b       The blue component of the text color (0-255).
     */
    public void log(String message, int r, int g, int b)
    {
        if (this.debug)
            this.logger.info("\u001B[38;2;{};{};{}m>>> {}" + RESET, r, g, b, message);
    }

    /**
     * Logs a message to the console with customizable RGB color formatting
     * for both the text and the background if debugging is enabled.
     * This method allows the user to specify the red, green, and blue
     * color components for the message text color and the background color.
     * The output will use the specified RGB values, making it easy to create
     * visually distinct log messages.
     *
     * @param message The message to log, intended for informational output.
     * @param rf      The red component of the text color (0-255).
     * @param gf      The green component of the text color (0-255).
     * @param bf      The blue component of the text color (0-255).
     * @param rb      The red component of the background color (0-255).
     * @param gb      The green component of the background color (0-255).
     * @param bb      The blue component of the background color (0-255).
     */
    public void log(String message, int rf, int gf, int bf, int rb, int gb, int bb)
    {
        if (this.debug)
            this.logger.info("\u001B[38;2;{};{};{};48;2;{};{};{}m>>> {} " + RESET, rf, gf, bf, rb, gb, bb, message);
    }

    /**
     * Logs an error message to the console.
     * This method logs the provided message using an error level log,
     * formatted with  vanilla's color for error message.
     * It is intended for indicating error conditions or significant issues
     * that need to be brought to the user's attention.
     *
     * @param message The error message to log, intended for error tracking.
     */
    public void logError(String message)
    {
        logError(message, false);
    }

    /**
     * Logs an error message to the console.
     * This method logs the provided message using an error level log,
     * formatted with a bright red background and black text for emphasis
     * (if the custom color flag is set true) or uses the normal vanilla
     * error message colors.
     * It is intended for indicating error conditions or significant issues
     * that need to be brought to the user's attention.
     *
     * @param message     The error message to log, intended for error tracking.
     * @param customColor Should we use custom black and red colors or not.
     */
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

    /**
     * Logs an error message to the console.
     * This method logs the provided message using an error level log,
     * formatted with the give color for text color.
     * It is intended for indicating error conditions or significant issues
     * that need to be brought to the user's attention.
     *
     * @param message    The error message to log, intended for error tracking.
     * @param foreground The font's color.
     */
    public void logError(String message, String foreground)
    {
        this.logger.error("{}>>> {}" + RESET, foreground, message);
        this.logger.trace(message);
    }

    /**
     * Logs an error message to the console.
     * This method logs the provided message using an error level log,
     * formatted with a given background and text for emphasis.
     * It is intended for indicating error conditions or significant issues
     * that need to be brought to the user's attention.
     *
     * @param message    The error message to log, intended for error tracking.
     * @param foreground The font's color.
     * @param background The text's background color.
     */
    public void logError(String message, String foreground, String background)
    {
        this.logger.error("{}{}>>> {}" + RESET, background, foreground, message);
        this.logger.trace(message);
    }

    /**
     * Logs a warning message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * warning message with vanilla's provided style for the warning messages.
     * This is intended for indicating potential issues or important notes
     * that may require attention.
     *
     * @param message The warning message to log, aimed at alerting users
     *                to possible concerns or conditions.
     */
    public void logWarning(String message)
    {
        logWarning(message, false);
    }

    /**
     * Logs a warning message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * warning message with bright yellow background and black text for visibility
     * (if the custom color flag is set to true) or vanilla's provided style for
     * the warning messages.
     * This is intended for indicating potential issues or important notes
     * that may require attention.
     *
     * @param message     The warning message to log, aimed at alerting users
     *                    to possible concerns or conditions.
     * @param customColor Should we use custom black and yellow colors or not.
     */
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

    /**
     * Logs a warning message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * warning message with given text color for the warning messages.
     * This is intended for indicating potential issues or important notes
     * that may require attention.
     *
     * @param message    The warning message to log, aimed at alerting users
     *                   to possible concerns or conditions.
     * @param foreground The font's color.
     */
    public void logWarning(String message, String foreground)
    {
        if (this.debug)
            this.logger.warn("{}>>> {}" + RESET, foreground, message);
    }

    /**
     * Logs a warning message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * warning message with given background and text colors for the warning messages.
     * This is intended for indicating potential issues or important notes
     * that may require attention.
     *
     * @param message    The warning message to log, aimed at alerting users
     *                   to possible concerns or conditions.
     * @param foreground The font's color.
     * @param background The text's background color.
     */
    public void logWarning(String message, String foreground, String background)
    {
        if (this.debug)
            this.logger.warn("{}{}>>> {}" + RESET, background, foreground, message);
    }


    /**
     * Logs a general message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * message without any special formatting. This is useful for outputting
     * standard messages that do not require specific color coding.
     *
     * @param message The message to log, intended for general informational output.
     */
    public void logN(String message)
    {
        if (this.debug)
            this.logger.info(">>> {}", message);
    }
}
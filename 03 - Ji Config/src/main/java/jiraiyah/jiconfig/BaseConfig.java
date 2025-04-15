/***********************************************************************************
 * Copyright (c) 2024 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.jiconfig;

import jiraiyah.logger.Logger;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Simple Config System: <a href="https://github.com/magistermaks/fabric-simplelibs/blob/master/simple-config/SimpleConfig.java"> GITHUB </a>
 */
@SuppressWarnings({"ResultOfMethodCallIgnored", "unused"})
public class BaseConfig
{
    private final HashMap<String, String> config = new HashMap<>();
    private final ConfigRequest request;
    private boolean broken = false;
    private static Logger LOGGER;
    private final ConfigKeyCasing casing;
    private boolean exists;

    /**
     * Constructs a new instance of `BaseConfig` with the specified module identifier,
     * configuration request, and key casing strategy.
     *
     * @param modid   the unique identifier for the mod that this configuration
     *                is associated with. This is typically used to differentiate between
     *                configurations of different mods within Minecraft.
     * @param request the `ConfigRequest` object that contains the details of the configuration
     *                file, including the file path and the provider for generating default
     *                configurations if necessary.
     * @param casing  the `ConfigKeyCasing` strategy to be applied to the configuration keys.
     *                This determines how the keys in the configuration file should be cased,
     *                such as no change, all upper case, or all lower case.
     */
    public BaseConfig(String modid, ConfigRequest request, ConfigKeyCasing casing)
    {
        LOGGER = new Logger(modid);
        this.casing = casing;
        this.request = request;
        this.exists = true;
        String identifier = "Config '" + request.getFilename() + "'";

        if (!request.getFile().exists())
        {
            LOGGER.logWarning(identifier + " is missing, generating default one...");

            try
            {
                createConfig();
            }
            catch (IOException e)
            {
                LOGGER.logError(identifier + " failed to generate! " + e.getMessage());
                broken = true;
            }
        }

        if (!broken)
        {
            try
            {
                loadConfig();
            }
            catch (Exception e)
            {
                LOGGER.logError(identifier + " failed to load! " + e.getMessage());
                broken = true;
            }
        }

    }

    /**
     * Creates new config request object, ideally `namespace`
     * should be the name of the mod id of the requesting mod
     *
     * @param filename The name of the config file
     *
     * @return new config request object
     */
    public static ConfigRequest of(String modid, String filename)
    {
        Path path = FabricLoader.getInstance().getConfigDir();
        return new ConfigRequest(path.resolve(modid + filename + ".ini").toFile(), modid + filename);
    }

    /**
     * Queries a value from config, returns `null` if the
     * key does not exist.
     *
     * @return value corresponding to the given key
     *
     * @see BaseConfig#getOrDefault
     */
    public String get(String key)
    {
        if(casing == ConfigKeyCasing.ALL_UPPER_CASE)
            return config.get(key.toUpperCase());
        if(casing == ConfigKeyCasing.ALL_LOWER_CASE)
            return config.get(key.toLowerCase());
        return config.get(key);
    }

    /**
     * Returns string value from config corresponding to the given
     * key, or the default string if the key is missing.
     *
     * @return value corresponding to the given key, or the default value
     */
    public String getOrDefault(String key, String def)
    {
        String val = get(key);
        if (val == null)
        {
            if(this.exists)
                LOGGER.logError("Failed to get the integer config value for " + key + " | Using default value: " + def);
            return def;
        }
        return val;
    }

    /**
     * Returns integer value from config corresponding to the given
     * key, or the default integer if the key is missing or invalid.
     *
     * @return value corresponding to the given key, or the default value
     */
    public int getOrDefault(String key, int def)
    {
        try
        {
            return Integer.parseInt(get(key));
        }
        catch (Exception e)
        {
            if(this.exists)
                LOGGER.logError("Failed to get the integer config value for " + key + " | Using default value: " + def + ". " + e.getMessage());

            return def;
        }
    }

    /**
     * Returns boolean value from config corresponding to the given
     * key, or the default boolean if the key is missing.
     *
     * @return value corresponding to the given key, or the default value
     */
    public boolean getOrDefault(String key, boolean def)
    {
        String val = get(key);

        if (val != null)
        {
            return val.equalsIgnoreCase("true");
        }

        if(this.exists)
            LOGGER.logError("Failed to get the double config value for " + key + " | Using default value: " + def);

        return def;
    }

    /**
     * Returns double value from config corresponding to the given
     * key, or the default string if the key is missing or invalid.
     *
     * @return value corresponding to the given key, or the default value
     */
    public double getOrDefault(String key, double def)
    {
        try
        {
            return Double.parseDouble(get(key));
        }
        catch (Exception e)
        {
            if(this.exists)
                LOGGER.logError("Failed to get the double config value for " + key + " | Using default value: " + def + ". " + e.getMessage());

            return def;
        }
    }

    /**
     * Creates a new config file with the default data provided in the request object.
     */
    private void createConfig() throws IOException
    {
        this.exists = false;
        // try creating missing files
        request.getFile().getParentFile().mkdirs();
        Files.createFile(request.getFile().toPath());
        // write default config data
        PrintWriter writer = new PrintWriter(request.getFile(), StandardCharsets.UTF_8);
        writer.write(request.getConfig());
        writer.close();
    }

    /**
     * Loads the config file and parses its contents into a HashMap.
     */
    private void loadConfig() throws IOException
    {
        Scanner reader = new Scanner(request.getFile());
        for (int line = 1; reader.hasNextLine(); line++)
            parseConfigEntry(reader.nextLine(), line);
        this.exists = true;
    }

    /**
     * Parses a single line of the config file and adds the key-value pair to the HashMap.
     *
     * @param entry The line to parse
     * @param line  The line number
     */
    private void parseConfigEntry(String entry, int line)
    {
        if (!entry.isEmpty() && !entry.startsWith("#"))
        {
            String[] parts = entry.replace(" ", "").split("=", 2); // Modification by Jiraiyah
            if (parts.length == 2)
                config.put(parts[0], parts[1].split("#")[0]); // Modification by Kaupenjoe
            else
                throw new RuntimeException("Syntax error in config file on line " + line + "!");
        }
    }

    /**
     * If any error occurred during loading or reading from the config
     * a 'broken' flag is set, indicating that the config's state
     * is undefined and should be discarded using `delete()`
     *
     * @return the 'broken' flag of the configuration
     */
    public boolean isBroken()
    {
        return broken;
    }

    /**
     * deletes the config file from the filesystem
     *
     * @return true if the operation was successful
     */
    public boolean delete()
    {
        LOGGER.logWarning("Config '" + request.getFilename() + "' was removed from existence! Restart the game to regenerate it.");
        return request.getFile().delete();
    }
}
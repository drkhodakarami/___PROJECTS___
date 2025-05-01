/***********************************************************************************
 * Copyright (c) 2025 Alireza Khodakarami (Jiraiyah)                               *
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

import jiraiyah.jibase.annotations.CreatedAt;
import jiraiyah.jibase.annotations.Developer;
import jiraiyah.jibase.annotations.Repository;
import jiraiyah.jilogger.JiLogger;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

@Developer("Magistermaks")
@CreatedAt("2025-04-18")
@Repository("https://github.com/magistermaks/fabric-simplelibs/blob/master/simple-config/SimpleConfig.java")

public class BaseConfig
{
    private final HashMap<String, String> config = new HashMap<>();
    private final ConfigRequest request;
    private boolean broken = false;
    private static JiLogger LOGGER;
    private final ConfigKeyCasing casing;
    private boolean exists;

    public BaseConfig(String modid, ConfigRequest request, ConfigKeyCasing casing)
    {
        LOGGER = new JiLogger(modid);
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

    public static ConfigRequest of(String modid, String filename)
    {
        Path path = FabricLoader.getInstance().getConfigDir();
        return new ConfigRequest(path.resolve(modid + filename + ".ini").toFile(), modid + filename);
    }

    public String get(String key)
    {
        if(casing == ConfigKeyCasing.ALL_UPPER_CASE)
            return config.get(key.toUpperCase());
        if(casing == ConfigKeyCasing.ALL_LOWER_CASE)
            return config.get(key.toLowerCase());
        return config.get(key);
    }

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

    private void createConfig() throws IOException
    {
        this.exists = false;
        //noinspection ResultOfMethodCallIgnored
        request.getFile().getParentFile().mkdirs();
        Files.createFile(request.getFile().toPath());
        PrintWriter writer = new PrintWriter(request.getFile(), StandardCharsets.UTF_8);
        writer.write(request.getConfig());
        writer.close();
    }

    private void loadConfig() throws IOException
    {
        Scanner reader = new Scanner(request.getFile());
        for (int line = 1; reader.hasNextLine(); line++)
            parseConfigEntry(reader.nextLine(), line);
        this.exists = true;
    }

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

    public boolean isBroken()
    {
        return broken;
    }

    public boolean delete()
    {
        LOGGER.logWarning("Config '" + request.getFilename() + "' was removed from existence! Restart the game to regenerate it.");
        return request.getFile().delete();
    }
}
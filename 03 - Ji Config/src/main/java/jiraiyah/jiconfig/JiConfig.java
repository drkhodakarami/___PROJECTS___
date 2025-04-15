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

/**
 * The main config entry class. Your mod's config class should extend this class.
 *
 * @author Jiraiyah
 */
@SuppressWarnings("unused")
public abstract class JiConfig
{
    private final String modId;
    protected BaseConfig config;
    protected ConfigProvider provider;

    public JiConfig(String modId)
    {
        this.modId = modId;
    }

    /**
     * @return the current config instance.
     */
    public BaseConfig getConfig()
    {
        return this.config;
    }

    /**
     * Loads the config for the specified mod. The keys will be saved using upper case letters.
     *
     */
    public void load()
    {
        load(ConfigKeyCasing.ALL_UPPER_CASE);
    }

    /**
     * Loads the config for the specified mod. The keys will be saved using provided letter casing.
     *
     */
    public void load(ConfigKeyCasing casing)
    {
        Logger logger = new Logger(this.modId);

        this.provider = new ConfigProvider(casing);
        this.createConfigs();

        logger.log("All " + provider.getConfigList().size() + " config entries have been set properly");

        this.config = BaseConfig.of(this.modId, "_config")
                                .provider(provider)
                                .request(this.modId, casing);

        this.assignConfigValues();

        if(!config.isBroken())
            logger.log("All " + provider.getConfigList().size() + " config entries have been loaded properly");
        else
            logger.logWarning("The loading process is at broken state!");
    }

    /**
     * Creates the config entries for the mod.
     */
    protected void createConfigs()
    {
    }

    /**
     * Assigns the values of the config entries to their respective variables.
     */
    protected void assignConfigValues()
    {
    }

}
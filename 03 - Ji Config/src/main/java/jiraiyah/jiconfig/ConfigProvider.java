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

import com.mojang.datafixers.util.Pair;
import jiraiyah.jibase.annotations.CreatedAt;
import jiraiyah.jibase.annotations.Developer;
import jiraiyah.jibase.annotations.ModifiedBy;

import java.util.ArrayList;
import java.util.List;

@Developer("Kaupenjoe")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")

@SuppressWarnings("unused")
public class ConfigProvider implements IConfigProvider
{
    private String configContent;
    private final List<Pair<String, ?>> configsList;
    private final ConfigKeyCasing casing;

    public ConfigProvider()
    {
        this(ConfigKeyCasing.NO_CHANGE);
    }

    public ConfigProvider(ConfigKeyCasing casing)
    {
        this.configContent = "";
        this.configsList = new ArrayList<>();
        this.casing = casing;
    }

    public List<Pair<String, ?>> getConfigList()
    {
        return configsList;
    }

    @Override
    public String get(String namespace)
    {
        return this.configContent;
    }

    public void addPair(Pair<String, ?> pair, String comment)
    {
        addPair(pair, comment, true, false);
    }

    public void addPair(Pair<String, ?> pair)
    {
        addPair(pair, true, false);
    }

    public void addPair(Pair<String, ?> pair, String comment, boolean addNewLine)
    {
        addPair(pair, comment, addNewLine, false);
    }

    public void addPair(Pair<String, ?> pair, boolean addNewLine)
    {
        addPair(pair, addNewLine, false);
    }

    public void addPair(Pair<String, ?> pair, String comment, boolean addNewLine, boolean isLast)
    {
        configsList.add(pair);
        configContent += "#The default value is: " + pair.getSecond() + " | " + pair.getSecond().getClass().getSimpleName() + "\n";
        configContent +=
                (this.casing == ConfigKeyCasing.NO_CHANGE
                 ? pair.getFirst()
                 : this.casing == ConfigKeyCasing.ALL_UPPER_CASE
                   ? pair.getFirst().toUpperCase()
                   : pair.getFirst().toLowerCase())
                + " = " + pair.getSecond() + " #" + comment;
        if (addNewLine)
            configContent += "\n\n";
        else if (!isLast)
            configContent += "\n";
    }

    public void addPair(Pair<String, ?> pair, boolean addNewLine, boolean isLast)
    {
        configsList.add(pair);
        configContent += "#The default value is: " + pair.getSecond() + " | " + pair.getSecond().getClass().getSimpleName() + "\n";
        configContent +=
                (this.casing == ConfigKeyCasing.NO_CHANGE
                 ? pair.getFirst()
                 : this.casing == ConfigKeyCasing.ALL_UPPER_CASE
                   ? pair.getFirst().toUpperCase()
                   : pair.getFirst().toLowerCase())
                + " = " + pair.getSecond();
        if (addNewLine)
            configContent += "\n\n";
        else if (!isLast)
            configContent += "\n";
    }

    public void addComment(String comment)
    {
        configContent += "#" + comment + "\n";
    }

    public void addNewLine()
    {
        configContent += "\n";
    }
}
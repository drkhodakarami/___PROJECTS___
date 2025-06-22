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

package jiraiyah.jibase.constants;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;

@SuppressWarnings("unused")
@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class TooltipConstants
{
    public static final String BLACK = "§0"; //#00_00_00
    public static final String DARK_BLUE = "§1"; //#00_00_AA
    public static final String DARK_GREEN = "§2"; //#00_AA_00
    public static final String DARK_AQUA = "§3"; //#00_AA_AA
    public static final String DARK_RED = "§4"; // #AA_00_00
    public static final String DARK_PURPLE = "§5"; // #AA_00_AA
    public static final String GOLD = "§6"; //#FF_AA_00
    public static final String GRAY = "§7"; //#AA_AA_AA
    public static final String DARK_GRAY = "§8"; //#55_55_55
    public static final String BLUE = "§9"; //#55_55_FF
    public static final String GREEN = "§a"; //#55_FF_55
    public static final String AQUA = "§b"; //#55_FF_FF
    public static final String RED = "§c"; //#FF_55_55
    public static final String LIGHT_PURPLE = "§d"; //#FF_55_FF
    public static final String YELLOW = "§e"; //#FF_FF_55
    public static final String WHITE = "§f"; //#FF_FF_FF
    public static final String STYLE_OBFUSCATED = "§k";
    public static final String STYLE_BOLD = "§l";
    public static final String STYLE_STRIKE = "§m";
    public static final String STYLE_UNDERLINE = "§n";
    public static final String STYLE_ITALIC = "§o";
    public static final String RESET = "§r";

    public TooltipConstants()
    {
        Exceptions.throwCtorAssertion();
    }
}
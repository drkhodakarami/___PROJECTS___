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

package jiraiyah.jibase.utils;

import jiraiyah.jibase.annotations.*;
import net.minecraft.entity.player.PlayerEntity;

@SuppressWarnings("unused")
@Developer("Direwolf20")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/Direwolf20-MC/JustDireThings")
@Youtube("https://www.youtube.com/@direwolf20")
public class XpHelper
{
    // Calculate experience required to go from level 0 to target level
    public static int totalXpForLevel(int level)
    {
        if(level <= 16)
            return level * level + 6 * level;
        if(level <= 31)
            return (int) (2.5 * level * level - 40.5 * level + 360);
        long totalXp = (long) (4.5 * level * level - 162.5 * level + 2220);
        return (int) Math.min(totalXp, Integer.MAX_VALUE);
    }

    public static int levelFromTotalXp(int totalXp)
    {
        // Check in the level ranges where experience requirements change
        if(totalXp < totalXpForLevel(16))
            // Level range 0-15
            return (int) Math.floor((-6 + Math.sqrt(36 + 4 * totalXp)) / 2);
        if(totalXp < totalXpForLevel(31))
            // Level range 16-30
            return (int) Math.floor((40.5 + Math.sqrt(1_640.25 - 10.0 * (360 - totalXp))) / 5.0);
        // Level range 31+
        return (int) Math.floor((162.5 + Math.sqrt(26_406.25 - 18.0 * (2220 - totalXp))) / 9.0);
    }

    // Remove levels from a player, ensuring they don't lose more than available
    public static int removeLevels(PlayerEntity player, int levelsToRemove)
    {
        int currentTotalExp = playerTotalXp(player);
        int targetLevel = Math.max(0, player.experienceLevel - levelsToRemove);

        // Calculate how much exp is required to be at the target level
        int targetTotalExp = totalXpForLevel(targetLevel);
        int expToRemove = currentTotalExp - targetTotalExp;

        player.addExperience(-levelsToRemove);
        return expToRemove;
    }

    // Calculate experience required to go from one level to the next
    public static int xpForNextLevel(int level)
    {
        if (level >= 30)
            return 112 + (level - 30) * 9;
        return level >= 15 ? 37 + (level - 15) * 5 : 7 + level * 2;
    }

    // Calculate total experience points player currently has (given level and progress)
    public static int playerTotalXp(PlayerEntity player)
    {
        int exp = totalXpForLevel(player.experienceLevel);
        long totalXp = (long) exp + (long) Math.round(player.experienceProgress * player.getNextLevelExperience());
        return (int) Math.min(totalXp, Integer.MAX_VALUE);
    }

    public static int xpNeededForNextLevel(PlayerEntity player)
    {
        return player.getNextLevelExperience() - (int) (player.experienceProgress * player.getNextLevelExperience());
    }

    // Get the progress to the next level as a fraction (float) from total experience points
    public static float progressToNextLevel(int totalExp)
    {
        int level = levelFromTotalXp(totalExp);  // Get the number of full levels
        int expForCurrentLevel = totalXpForLevel(level);  // Total exp required to reach this level
        int expForNextLevel = xpForNextLevel(level);  // Exp needed for the next level

        // Remaining experience after subtracting full levels
        int expAfterFullLevels = totalExp - expForCurrentLevel;

        // Calculate the fractional progress (as a float between 0.0 and 1.0)
        return (float) expAfterFullLevels / (float) expForNextLevel;
    }

    // Remove points from a player, ensuring they don't lose more than available
    public static int removePoints(PlayerEntity player, int pointsToRemove)
    {
        int currentTotalExp = playerTotalXp(player);
        int expToRemove = Math.min(currentTotalExp, pointsToRemove);
        player.addExperience(-expToRemove);
        return expToRemove;  // Amount of exp removed
    }
}
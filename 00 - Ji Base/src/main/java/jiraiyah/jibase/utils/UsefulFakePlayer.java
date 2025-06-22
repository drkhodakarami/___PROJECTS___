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

import com.mojang.authlib.GameProfile;
import jiraiyah.jibase.annotations.CreatedAt;
import jiraiyah.jibase.annotations.Developer;
import jiraiyah.jibase.annotations.Repository;
import jiraiyah.jibase.annotations.Youtube;
import net.fabricmc.fabric.api.entity.FakePlayer;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
@Developer("Direwolf20")
@CreatedAt("2025-04-18")
@Repository("https://github.com/Direwolf20-MC/JustDireThings")
@Youtube("https://www.youtube.com/@direwolf20")
public class UsefulFakePlayer extends FakePlayer
{
    private double reach;

    protected UsefulFakePlayer(ServerWorld world, GameProfile profile)
    {
        super(world, profile);
    }

    @Override
    public float getAttackCooldownProgress(float baseTime)
    {
        return 1; // Prevent the attack strength from always being 0.03 due to not ticking.
    }

    @Override
    public ItemCooldownManager getItemCooldownManager()
    {
        return new ItemCooldownManager(); //Prevent item cool downs due to player not ticking
    }

    @Override
    public boolean isPartOfGame()
    {
        return false; //Prevent them being targeted by mobs?
    }

    public void fakeUpdateUsingItem(ItemStack stack)
    {
        this.tickItemStackUsage(stack);
    }

    @Override
    public @Nullable ServerPlayerEntity teleportTo(TeleportTarget teleportTarget)
    {
        return createPlayer(teleportTarget.world(), this.getGameProfile());
    }

    public double getReach() {
        return reach;
    }

    public void setReach(double reach)
    {
        this.reach = reach;
    }

    public static UsefulFakePlayer createPlayer(ServerWorld world, GameProfile profile)
    {
        return new UsefulFakePlayer(world, profile);
    }

    public static UsefulFakePlayer createPlayer(ServerWorld world)
    {
        return new UsefulFakePlayer(world, FakePlayer.get(world).getGameProfile());
    }
}
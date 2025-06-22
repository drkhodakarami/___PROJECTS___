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

package jiraiyah.ultraio.block.machine;

import com.mojang.serialization.MapCodec;
import jiraiyah.jibase.properties.BlockProperties;
import jiraiyah.jiralib.block.JiBlock;
import jiraiyah.ultraio.blockentity.machine.GemCleanerBE;
import jiraiyah.ultraio.registry.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GemCleaner extends JiBlock implements BlockEntityProvider
{
    public GemCleaner(Settings settings)
    {
        super(settings, new BlockProperties<>(() -> ModBlockEntities.GEM_CLEANER)
                                .addLitProperty()
                                .addHorizontalFacing()
                                .tick()
                                .addInventory()
                                .addGui());

        CODEC = createCodec(GemCleaner::new);
    }

    //TODO: Fix this !
    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player)
    {
        var be = world.getBlockEntity(pos);
        if(be instanceof GemCleanerBE blockEntity)
            blockEntity.getInventoryConnector().dropContent(world, pos);

        return super.onBreak(world, pos, state, player);
    }
}
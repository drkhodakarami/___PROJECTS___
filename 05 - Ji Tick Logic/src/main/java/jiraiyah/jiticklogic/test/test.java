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

package jiraiyah.jiticklogic.test;

import jiraiyah.jiticklogic.base.AggregationPolicy;
import jiraiyah.jiticklogic.base.LogicTree;
import jiraiyah.jiticklogic.logic.HandleResourceSubTree;
import jiraiyah.jiticklogic.node.*;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.block.entity.BlockEntity;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class test<T extends BlockEntity>
{

    LogicTree<T> logicTree;

    public void initTree()
    {
        if(this.properties == null || this.properties.blockentity() == null)
            return;

        HandleResourceSubTree<T> handleEnergySubTree = new HandleResourceSubTree<>(true, this.properties, null, -10,
                                                                       this.properties.blockentity()::getEnergyAmount,
                                                                       this.properties.blockentity()::getEnergyMaxAmount,
                                                                       this.properties.blockentity()::adjustEnergyAmount);

        HandleResourceSubTree<T> handleFluidSubTree = new HandleResourceSubTree<>(true, this.properties, null, -FluidConstants.DROPLET * 10,
                                                                                   this.properties.blockentity()::getFluidAmount,
                                                                                   this.properties.blockentity()::getFluidMaxAmount,
                                                                                   this.properties.blockentity()::adjustFluidAmount);

        SubTreeNode<T> energySubTreeNode = new SubTreeNode<>(null, handleEnergySubTree);
        SubTreeNode<T> fluidSubTreeNode = new SubTreeNode<>(null, handleFluidSubTree);
        SequenceNode<T> root = new SequenceNode<>(null);

        root.addChild(energySubTreeNode);
        root.addChild(fluidSubTreeNode);

        logicTree = new LogicTree<>(this.properties, root, null, AggregationPolicy.SUCCEED_IF_ALL_SUCCESS);

    }

    public void tick()
    {
        logicTree.tick();
    }
}
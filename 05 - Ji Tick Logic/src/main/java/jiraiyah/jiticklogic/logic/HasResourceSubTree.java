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

package jiraiyah.jiticklogic.logic;

import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jiticklogic.base.AggregationPolicy;
import jiraiyah.jiticklogic.base.Blackboard;
import jiraiyah.jiticklogic.base.LogicTree;
import jiraiyah.jiticklogic.node.*;
import net.minecraft.block.entity.BlockEntity;

import java.util.function.Supplier;

public class HasResourceSubTree<T extends BlockEntity> extends LogicTree<T>
{
    public HasResourceSubTree(boolean shouldUseResource, BEProperties<T> properties, Blackboard blackboard,
                              Supplier<Long> resourceAmountSupplier)
    {
        super();
        this.properties = properties;
        this.blackboard = blackboard;
        initTree(shouldUseResource, resourceAmountSupplier);
    }

    private void initTree(boolean useResource, Supplier<Long> resourceAmountSupplier)
    {
        ConditionNode<T> shouldUseResource = new ConditionNode<T>(this.blackboard, () -> useResource);
        ConditionNode<T> shouldUseResourceNegated = new ConditionNode<T>(this.blackboard, () -> useResource);
        ConditionNode<T> hasResourceNode = new ConditionNode<T>(this.blackboard, () -> resourceAmountSupplier != null && resourceAmountSupplier.get() > 0);
        SequenceNode<T> resourceCheckSequence = new SequenceNode<T>(this.blackboard);
        NotNode<T> shouldUseResourceNot = new NotNode<T>(this.blackboard);
        SequenceNode<T> root = new SequenceNode<>(blackboard);

        resourceCheckSequence.addChild(shouldUseResource);
        resourceCheckSequence.addChild(hasResourceNode);

        hasResourceNode.addChild(shouldUseResourceNegated);

        root.addChild(resourceCheckSequence);
        root.addChild(shouldUseResourceNot);

        startNode = new StartNode<>(root, this.blackboard, AggregationPolicy.SUCCEED_IF_ALL_SUCCESS);
        this.startNode.setTree(this, properties);
    }
}
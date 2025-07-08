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

package jiraiyah.jiticklogic.node;

import jiraiyah.jibase.enumerations.TickStatus;
import jiraiyah.jiticklogic.base.AggregationPolicy;
import jiraiyah.jiticklogic.base.Blackboard;
import jiraiyah.jiticklogic.base.IRunningNodeManager;
import jiraiyah.jiticklogic.base.Node;
import net.minecraft.block.entity.BlockEntity;

import java.util.ArrayList;
import java.util.List;

public class StartNode<T extends BlockEntity> extends Node<T>
{
    private List<Node<T>> runningNodes = new ArrayList<>();
    private final AggregationPolicy aggregationPolicy;

    public StartNode(Node<T> root, Blackboard blackboard, AggregationPolicy aggregationPolicy)
    {
        super(blackboard);
        children.add(root);
        this.aggregationPolicy = aggregationPolicy;
    }

    @Override
    public TickStatus tick()
    {
        if(children.isEmpty())
            return TickStatus.ERROR;

        if(runningNodes.isEmpty())
        {
            this.tree.reset();

            TickStatus result = children.getFirst().tick();

            if(!(children.getFirst().getParent() instanceof IRunningNodeManager) && result == TickStatus.RUNNING)
                runningNodes.add(children.getFirst());

            return result;
        }
        else
        {
            List<Node<T>> nextRunningNodes = new ArrayList<>();

            int successCount = 0, failedCount = 0, runningCount = 0;

            for (Node<T> node : runningNodes)
            {
                TickStatus result = node.tick();

                switch (result)
                {
                    case TickStatus.SUCCESS: successCount++; break;
                    case TickStatus.FAILURE: failedCount++; break;
                    case TickStatus.RUNNING:
                        if (!(node.getParent() instanceof IRunningNodeManager))
                            nextRunningNodes.add(node);
                        runningCount++;
                        break;
                }
            }

            runningNodes = nextRunningNodes;

            if(runningCount > 0) return TickStatus.RUNNING;

            //noinspection EnhancedSwitchMigration
            switch (aggregationPolicy)
            {
                case SUCCEED_ON_ANY_SUCCESS, FAIL_IF_ALL_FAILURE:
                    if(successCount > 0) return TickStatus.SUCCESS;
                    return TickStatus.FAILURE;
                case FAIL_ON_ANY_FAILURE, SUCCEED_IF_ALL_SUCCESS:
                    if(failedCount > 0) return TickStatus.FAILURE;
                    return TickStatus.SUCCESS;
                default:
                    return TickStatus.FAILURE;
            }
        }
    }

    public void addRunningNode(Node<T> node)
    {
        if(node.getParent() instanceof IRunningNodeManager)
            return;

        if(!runningNodes.contains(node))
            runningNodes.add(node);
    }

    @Override
    public void reset()
    {
        super.reset();
        runningNodes.clear();
    }
}
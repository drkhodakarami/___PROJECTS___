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
import jiraiyah.jiticklogic.base.Blackboard;
import jiraiyah.jiticklogic.base.IRunningNodeManager;
import jiraiyah.jiticklogic.base.Node;
import net.minecraft.block.entity.BlockEntity;

import java.util.ArrayList;
import java.util.List;

public class ParallelNode<T extends BlockEntity> extends Node<T> implements IRunningNodeManager
{
    private int successThreshold;
    private int successCount;
    private int runningCount;
    private List<TickStatus> childStatuses;

    public ParallelNode(int successThreshold)
    {
        super();
        this.successThreshold = successThreshold;
        this.childStatuses = new ArrayList<>();
        this.successCount = 0;
        this.runningCount = 0;
    }

    public ParallelNode(Blackboard blackboard, int successThreshold)
    {
        super(blackboard);
        this.successThreshold = successThreshold;
        this.childStatuses = new ArrayList<>();
        this.successCount = 0;
        this.runningCount = 0;
    }

    @Override
    public TickStatus tick()
    {
        if(children.isEmpty())
            return TickStatus.ERROR;

        if(childStatuses.isEmpty())
            for (int i = 0; i < children.size(); i++)
                childStatuses.add(TickStatus.FAILURE);

        for (int i = 0; i < children.size(); i++)
        {
            Node<T> child = children.get(i);

            if(childStatuses.get(i) != TickStatus.SUCCESS)
            {
                TickStatus status = child.tick();
                childStatuses.set(i, status);

                if(status == TickStatus.RUNNING)
                    runningCount++;
            }
        }

        if(successCount >= successThreshold)
            return TickStatus.SUCCESS;

        if(successCount + runningCount >= successThreshold)
        {
            tree.addRunningNode(this);
            return TickStatus.RUNNING;
        }

        return TickStatus.FAILURE;
    }

    @Override
    public void reset()
    {
        super.reset();
        childStatuses.clear();
        successCount = 0;
        runningCount = 0;
    }
}
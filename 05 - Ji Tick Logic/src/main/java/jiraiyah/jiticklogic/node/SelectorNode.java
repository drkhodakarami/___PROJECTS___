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

/**
 * Represents a selector node in a tick logic system.
 *
 * <p>Selector nodes evaluate its child nodes sequentially and returns the first success or running status encountered.</p>
 */
public class SelectorNode<T extends BlockEntity> extends Node<T> implements IRunningNodeManager
{
    /**
     * The current index of the child node being evaluated.
     */
    private int currentChildIndex = 0;

    /**
     * The child node currently being evaluated.
     */
    private Node<T> runningChild = null;

    /**
     * Constructs a SelectorNode with no Blackboard.
     */
    public SelectorNode()
    {
        super();
    }

    /**
     * Constructs a SelectorNode with a Blackboard.
     *
     * @param blackboard the Blackboard instance
     */
    public SelectorNode(Blackboard blackboard)
    {
        super(blackboard);
    }

    /**
     * Evaluates child nodes sequentially and returns the first success or running status encountered.
     *
     * @return the tick status of the evaluated child node
     */
    @Override
    public TickStatus tick()
    {
        if(children.isEmpty())
            return TickStatus.ERROR;

        if(runningChild != null)
            currentChildIndex = children.indexOf(runningChild);

        while (currentChildIndex < children.size())
        {
            Node<T> child = children.get(currentChildIndex);

            TickStatus status = child.tick();

            if(status == TickStatus.SUCCESS)
            {
                currentChildIndex = 0;
                return TickStatus.SUCCESS;
            }

            if(status == TickStatus.RUNNING)
            {
                tree.addRunningNode(this);
                runningChild = child;
                return TickStatus.RUNNING;
            }

            currentChildIndex++;
        }

        currentChildIndex = 0;
        return TickStatus.FAILURE;
    }

    /**
     * Evaluates child nodes sequentially and returns the first success or running status encountered.
     *
     */
    @Override
    public void reset()
    {
        super.reset();
        currentChildIndex = 0;
        runningChild = null;
    }
}
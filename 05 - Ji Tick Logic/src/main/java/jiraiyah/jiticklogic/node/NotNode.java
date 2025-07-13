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
 * Represents a not node in a tick logic system.
 *
 * <p>Not nodes invert the tick status of their child node.</p>
 */
public class NotNode<T extends BlockEntity> extends Node<T> implements IRunningNodeManager
{
    /**
     * Constructs a NotNode with no Blackboard.
     */
    public NotNode()
    {
        super();
    }

    /**
     * Constructs a NotNode with a Blackboard.
     *
     * @param blackboard the Blackboard instance
     */
    public NotNode(Blackboard blackboard)
    {
        super(blackboard);
    }

    /**
     * Inverts the tick status of the child node and returns it.
     *
     * @return the inverted tick status based on the evaluation of the child node
     */
    @Override
    public TickStatus tick()
    {
        if(children.isEmpty())
            return TickStatus.ERROR;

        TickStatus status = children.getFirst().tick();

        if(status == TickStatus.FAILURE)
            return TickStatus.SUCCESS;

        if(status == TickStatus.SUCCESS)
            return TickStatus.FAILURE;

        if(status == TickStatus.RUNNING)
            tree.addRunningNode(this);

        return status;
    }
}
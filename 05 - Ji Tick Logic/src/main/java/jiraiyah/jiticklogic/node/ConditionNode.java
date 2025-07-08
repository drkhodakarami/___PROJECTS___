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
import jiraiyah.jiticklogic.base.Node;
import net.minecraft.block.entity.BlockEntity;

import java.util.function.Supplier;

public class ConditionNode<T extends BlockEntity> extends Node<T>
{
    private Supplier<Boolean> condition;

    public ConditionNode(Supplier<Boolean> condition)
    {
        super();
        this.condition = condition;
    }

    public ConditionNode(Blackboard blackboard, Supplier<Boolean> condition)
    {
        super(blackboard);
        this.condition = condition;
    }

    @Override
    public TickStatus tick()
    {
        try
        {
            if(condition.get())
                return TickStatus.SUCCESS;
            else
                return TickStatus.FAILURE;
        }
        catch (Exception e)
        {
            getLogger().logError("Error evaluating condition: " + e.getMessage());
            return TickStatus.ERROR;
        }
    }

    public void setCondition(Supplier<Boolean> condition)
    {
        this.condition = condition;
    }
}
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

package jiraiyah.jiticklogic.base;

import jiraiyah.jibase.enumerations.TickStatus;
import jiraiyah.jibase.properties.BEProperties;
import jiraiyah.jilogger.JiLogger;
import jiraiyah.jiticklogic.node.ParallelNode;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Node<T extends BlockEntity>
{
    protected Blackboard blackboard;
    protected List<Node<T>> children = new ArrayList<>();
    protected Node<T> parent;
    protected LogicTree<T> tree;
    protected BEProperties<T> properties;

    public Node()
    {}

    public Node(Blackboard blackboard)
    {
        this.blackboard = blackboard;
    }

    public void addChild(Node<T> child)
    {
        child.parent = this;
        children.add(child);
    }

    public void setTree(LogicTree<T> tree, BEProperties<T> properties)
    {
        this.tree = tree;
        this.properties = properties;
        for(Node<T> child : children)
            child.setTree(tree, properties);
    }

    public void reset()
    {
        for (Node<T> child : children)
            child.reset();
    }

    public Node<T> getParent()
    {
        return parent;
    }

    public boolean isChildOfParallelNode()
    {
        return parent instanceof ParallelNode;
    }

    public JiLogger getLogger()
    {
        return this.tree.getLogger();
    }

    public NbtCompound writeNbt()
    {
        NbtCompound nbt = new NbtCompound();

        if(!children.isEmpty())
        {
            NbtList childrenList = new NbtList();
            for(Node<T> child : children)
                childrenList.add(child.writeNbt());
            nbt.put("children", childrenList);
        }

        return nbt;
    }

    public void readNbt(NbtCompound nbt)
    {
        if(nbt.contains("children"))
        {
            Optional<NbtList> childrenList = nbt.getList("children");
            childrenList.ifPresent(list ->
                                   {
                                       for(int i = 0; i < list.size() && i < children.size(); i++)
                                       {
                                           Optional<NbtCompound> childCompound = list.getCompound(i);
                                           Node<T> child = children.get(i);
                                           childCompound.ifPresent(child::readNbt);
                                       }
                                   });
        }
    }

    public abstract TickStatus tick();
}
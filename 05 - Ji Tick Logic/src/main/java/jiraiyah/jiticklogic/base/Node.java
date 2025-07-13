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

/**
 * Represents a node in a logic tree used for managing tick logic.
 *
 * @param <T> the type of block entity associated with this node
 */
public abstract class Node<T extends BlockEntity>
{
    /**
     * The blackboard used to store and retrieve data during tick operations.
     */
    protected Blackboard blackboard;

    /**
     * A list of child nodes that are part of this node's subtree.
     */
    protected List<Node<T>> children = new ArrayList<>();

    /**
     * The parent node of this node.
     */
    protected Node<T> parent;

    /**
     * The logic tree to which this node belongs.
     */
    protected LogicTree<T> tree;

    /**
     * Properties associated with the block entity.
     */
    protected BEProperties<T> properties;

    /**
     * Constructs an empty Node instance.
     */
    public Node()
    {}

    /**
     * Constructs a Node instance with the specified blackboard.
     *
     * @param blackboard the blackboard used to store data during tick operations
     */
    public Node(Blackboard blackboard)
    {
        this.blackboard = blackboard;
    }

    /**
     * Adds a child node to this node's subtree.
     *
     * @param child the child node to add
     */
    public void addChild(Node<T> child)
    {
        child.parent = this;
        children.add(child);
    }

    /**
     * Sets the logic tree and properties for this node and all its children.
     *
     * @param tree    the logic tree to which this node belongs
     * @param properties the properties associated with the block entity
     */
    public void setTree(LogicTree<T> tree, BEProperties<T> properties)
    {
        this.tree = tree;
        this.properties = properties;
        for(Node<T> child : children)
            child.setTree(tree, properties);
    }

    /**
     * Resets all nodes in the subtree rooted at this node.
     */
    public void reset()
    {
        for (Node<T> child : children)
            child.reset();
    }

    /**
     * Retrieves the parent node of this node.
     *
     * @return the parent node, or null if there is no parent
     */
    public Node<T> getParent()
    {
        return parent;
    }

    /**
     * Checks if this node is a child of a parallel node.
     *
     * @return true if this node is a child of a parallel node, false otherwise
     */
    public boolean isChildOfParallelNode()
    {
        return parent instanceof ParallelNode;
    }

    /**
     * Retrieves the logger instance associated with this node's logic tree.
     *
     * @return the JiLogger instance
     */
    public JiLogger getLogger()
    {
        return this.tree.getLogger();
    }

    /**
     * Writes the data of this node and its children to an NBT compound.
     *
     * @return the NBT compound representation of the node and its children
     */
    public NbtCompound writeData()
    {
        NbtCompound nbt = new NbtCompound();

        if(!children.isEmpty())
        {
            NbtList childrenList = new NbtList();
            for(Node<T> child : children)
                childrenList.add(child.writeData());
            nbt.put("children", childrenList);
        }

        return nbt;
    }

    /**
     * Reads the data of this node and its children from an NBT compound.
     *
     * @param nbt the NBT compound representation of the node and its children
     */
    public void readData(NbtCompound nbt)
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
                                           childCompound.ifPresent(child::readData);
                                       }
                                   });
        }
    }

    /**
     * Ticks this node and its subtree.
     *
     * @return the tick status of this node
     */
    public abstract TickStatus tick();
}
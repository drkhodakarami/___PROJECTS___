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
import jiraiyah.jiticklogic.node.StartNode;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;

import java.util.Optional;

@SuppressWarnings("FieldCanBeLocal")
public class LogicTree<T extends BlockEntity>
{
    protected Blackboard blackboard;
    protected BEProperties<T> properties;
    private final JiLogger logger = new JiLogger("tick_logic");

    protected StartNode<T> startNode;

    public LogicTree()
    {}

    public LogicTree(BEProperties<T> properties, Node<T> root, Blackboard blackboard, AggregationPolicy aggregationPolicy)
    {
        this.properties = properties;
        startNode = new StartNode<>(root, blackboard, aggregationPolicy);
        this.blackboard = blackboard;
        this.startNode.setTree(this, properties);
    }

    public TickStatus tick()
    {
        return startNode.tick();
    }

    public void reset()
    {
        this.startNode.reset();
    }

    public Blackboard getBlackboard()
    {
        return blackboard;
    }

    public void addRunningNode(Node<T> node)
    {
        startNode.addRunningNode(node);
    }

    public JiLogger getLogger()
    {
        return logger;
    }

    public NbtCompound writeNbt()
    {
        NbtCompound nbt = new NbtCompound();

        nbt.put("blackboard", blackboard.writeNbt());

        if(startNode != null)
            nbt.put("startNode", startNode.writeNbt());

        return nbt;
    }

    public void readNbt(NbtCompound nbt)
    {
        if(nbt.contains("blackboard"))
        {

            Optional<NbtCompound> optional = nbt.getCompound("blackboard");
            optional.ifPresent(compound -> {
                Blackboard loaded = Blackboard.readNbt(compound);
                blackboard.clear();
                blackboard.getData().putAll(loaded.getData());
            });
        }

        if(nbt.contains("startNode") && startNode != null)
        {
            Optional<NbtCompound> optional = nbt.getCompound("startNode");
            optional.ifPresent(compound -> startNode.readNbt(compound));
        }
    }
}
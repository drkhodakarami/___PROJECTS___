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

package jiraiyah.jibase.data;

import jiraiyah.jibase.annotations.CreatedAt;
import jiraiyah.jibase.annotations.Developer;
import jiraiyah.jibase.annotations.Repository;
import jiraiyah.jibase.annotations.Youtube;
import net.minecraft.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

@Developer("Direwolf20")
@CreatedAt("2025-04-18")
@Repository("https://github.com/Direwolf20-MC/JustDireThings")
@Youtube("https://www.youtube.com/@direwolf20")
public class FilterData
{
    public boolean allowList = false;
    public boolean compareNBT = false;
    public int blockItemFilter = -1;

    // This is not saved in NBT, and is recreated as needed on demand
    public final Map<ItemStackKey, Boolean> filterCache = new HashMap<>();
    public final WeakHashMap<Entity, Boolean> entityCache = new WeakHashMap<>();

    public FilterData() {}

    public FilterData(boolean allowList, boolean compareNBT, int blockItemFilter)
    {
        this.allowList = allowList;
        this.compareNBT = compareNBT;
        this.blockItemFilter = blockItemFilter;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(allowList, compareNBT, blockItemFilter);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        FilterData that = (FilterData) obj;
        return allowList == that.allowList &&
               compareNBT == that.compareNBT &&
               blockItemFilter == that.blockItemFilter;
    }
}
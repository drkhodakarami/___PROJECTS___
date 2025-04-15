package jiraiyah.jinventory;

import org.spongepowered.include.com.google.common.base.Objects;

import java.util.function.Supplier;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public class PredicateKey
{
    private final Supplier<Boolean> canInsert;
    private final Supplier<Boolean> canExtract;

    public PredicateKey(Supplier<Boolean> canInsert, Supplier<Boolean> canExtract)
    {
        this.canInsert = canInsert;
        this.canExtract = canExtract;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        PredicateKey that = (PredicateKey) obj;
        return Objects.equal(canInsert, that.canInsert) &&
               Objects.equal(canExtract, that.canExtract);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(canInsert, canExtract);
    }
}
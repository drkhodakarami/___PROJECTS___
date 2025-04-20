package jiraiyah.jinventory;

import jiraiyah.jibase.annotations.*;
import org.spongepowered.include.com.google.common.base.Objects;

import java.util.function.Supplier;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

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
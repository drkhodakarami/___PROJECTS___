package jiraiyah.jibase.utils;

import jiraiyah.jibase.annotations.*;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.storage.TransferVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@Developer("TurtyWurty")
@ModifiedBy("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/DaRealTurtyWurty/Industria")
@Discord("https://discord.turtywurty.dev/")
@Youtube("https://www.youtube.com/@TurtyWurty")

public class TransferHelper
{
    public static <V, T extends TransferVariant<V>>Optional<T> findFirstVariant(Storage<T> storage, @Nullable T variant, long transferAmount)
    {
        if(storage instanceof SingleVariantStorage<T> singleVariantStorage)
            return Optional.ofNullable((T) singleVariantStorage.variant);

        if(variant != null && !variant.isBlank())
        {
            try (Transaction transaction = Transaction.openOuter())
            {
                if(storage.extract(variant, transferAmount, transaction) > 0)
                    return Optional.of(variant);

                return Optional.empty();
            }
        }

        for (StorageView<T> storageView : storage.nonEmptyViews())
            return Optional.ofNullable(storageView.getResource());

        return Optional.empty();
    }
}
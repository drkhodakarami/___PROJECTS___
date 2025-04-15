package jiraiyah.ultraio.command.suggestion;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.server.command.ServerCommandSource;

import java.util.concurrent.CompletableFuture;

public class DclrSuggestionProvider implements SuggestionProvider<ServerCommandSource>
{
    @Override
    public CompletableFuture<Suggestions> getSuggestions(CommandContext<ServerCommandSource> context, SuggestionsBuilder builder) throws CommandSyntaxException
    {
        builder.suggest("ore")
               .suggest("block")
               .suggest("fluid")
               .suggest("all");
        return builder.buildFuture();
    }
}
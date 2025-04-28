package jiraiyah.jireference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.constants.BEKeys;
import jiraiyah.jibase.utils.BaseHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class JiReference
{
    private final String modId;

    public JiReference(String mod_ID)
     {
         this.modId = mod_ID;
     }

    public String ModID()
     {
         return modId;
     }

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public <T> RegistryKey<T> getKey(String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return BaseHelper.getKey(ModID(), name, registryKey);
    }

    @NotNull
    public Identifier identifier(@NotNull String path)
     {
         return Identifier.of(ModID(), path);
     }

    @NotNull
    public Identifier vanillaID(@NotNull String path)
     {
         return Identifier.ofVanilla(path);
     }

    @NotNull
    public Identifier idOf(@NotNull String path)
     {
         return Identifier.of(path);
     }

    public MutableText translate(String key, Object... params)
     {
         return Text.translatable(ModID() + "." + key, params);
     }

    public MutableText translateContainer(String key, Object... params)
     {
         return Text.translatable(ModID() + ".container." + key, params);
     }

    protected TagKey<Block> createBlockTag(String name)
     {
         return TagKey.of(RegistryKeys.BLOCK, identifier(name));
     }

    protected TagKey<Block> createBlockCommonTag(String name)
     {
         return TagKey.of(RegistryKeys.BLOCK, Identifier.tryParse("c", name));
     }

    protected TagKey<Item> createItemTag(String name)
     {
         return TagKey.of(RegistryKeys.ITEM, identifier(name));
     }

    protected TagKey<Item> createItemCommonTag(String name)
     {
         return TagKey.of(RegistryKeys.ITEM, Identifier.tryParse("c", name));
     }

    protected TagKey<EntityType<?>> createEntityTag(String name)
     {
         return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier(name));
     }

    protected TagKey<EntityType<?>> createEntityCommonTag(String name)
     {
         return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.tryParse("c", name));
     }

    public String energyAmountKey()
     {
         return this.modId + BEKeys.ENERGY_AMOUNT;
     }

    public String energyCapacityKey()
     {
         return this.modId + BEKeys.ENERGY_CAPACITY;
     }

    public String hasEnergyKey()
     {
         return this.modId + BEKeys.HAS_ENERGY;
     }

    public String fluidAmountKey()
     {
         return this.modId + BEKeys.FLUID_AMOUNT;
     }

    public String fluidCapacityKey()
     {
         return this.modId + BEKeys.FLUID_CAPACITY;
     }

    public String hasFluidKey()
     {
         return this.modId + BEKeys.HAS_FLUID;
     }

    public String progressAmountKey()
     {
         return this.modId + BEKeys.PROGRESS_AMOUNT;
     }

    public String maxProgressKey()
     {
         return this.modId + BEKeys.PROGRESS_MAX;
     }

    public String cooldownAmountKey()
     {
         return this.modId + BEKeys.COOLDOWN_AMOUNT;
     }

    public String maxCooldownKey()
     {
         return this.modId + BEKeys.COOLDOWN_MAX;
     }

    public String burnAmountKey()
     {
         return this.modId + BEKeys.BURN_AMOUNT;
     }

    public String maxBurnKey()
     {
         return this.modId + BEKeys.BURN_MAX;
     }

    public String hasInventoryKey()
     {
         return this.modId + BEKeys.HAS_INVENTORY;
     }

    public String dirtyKey()
    {
        return this.modId + BEKeys.IS_DIRTY;
    }

    public String dirtyClientKey()
    {
        return this.modId + BEKeys.IS_DIRTY_CLIENT;
    }

    public String worldKey()
    {
        return this.modId + BEKeys.WORLD;
    }

    public String posKey()
    {
        return this.modId + BEKeys.POS;
    }

    public String cachedStateKey()
    {
        return this.modId + BEKeys.CACHED_STATE;
    }

    public String ticksKey()
    {
        return this.modId + BEKeys.IS_DIRTY;
    }

    public String ticksClientKey()
    {
        return this.modId + BEKeys.IS_DIRTY;
    }
}
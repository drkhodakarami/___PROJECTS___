package jiraiyah.jireference;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.constants.BEKeys;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
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
     /**
      * The mod ID associated with this instance of `JiReference`.
      *
      * <p>This private attribute holds the unique identifier for the mod, which is used
      * throughout the class to create identifiers, log messages, and manage localization.
      * The mod ID ensures that all resources, logs, and translations are correctly
      * associated with this specific mod, providing a consistent reference point
      * within the mod's codebase.</p>
      */
     private final String modId;

     /**
      * Constructs a new `JiReference` instance with the specified mod ID.
      *
      * <p>This constructor initializes the `JiReference` object by setting the mod ID
      * and creating a `Logger` instance. The `Logger` is configured to use the mod ID
      * as a prefix for all log messages, ensuring that log entries are easily
      * identifiable and associated with this specific mod.</p>
      *
      * @param mod_ID The mod ID to be used for this instance. It is used for
      *               creating identifiers and logging messages specific to the mod.
      */
     public JiReference(String mod_ID)
     {
         this.modId = mod_ID;
     }

     /**
      * Retrieves the current mod ID.
      *
      * <p>This method returns the mod ID that is currently set in the
      * class. It is used to ensure that all references to the
      * mod's resources are correctly prefixed with the mod's ID.</p>
      *
      * @return A `String` representing the current mod ID.
      */
     public String ModID()
     {
         return modId;
     }

     /**
      * A `Gson` instance configured for pretty printing and with HTML escaping disabled.
      *
      * <p>This `Gson` object is used for serialization and deserialization of JSON data
      * within the mod. The pretty printing configuration ensures that the JSON output
      * is formatted in a human-readable way, while disabling HTML escaping allows for
      * the inclusion of special characters in the JSON strings without being escaped.</p>
      */
     public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

     /**
      * Constructs a `Identifier` for the given path using the mod's ID.
      * This method creates an identifier that is used to reference
      * resources within the mod. It combines the mod's ID with
      * the provided path to ensure that the identifier is unique within
      * the Minecraft ecosystem.
      *
      * @param path The path string to be combined with the mod's ID.
      *
      * @return A new `Identifier` instance formed by the mod's ID and the specified path.
      */
     @NotNull
     public Identifier identifier(@NotNull String path)
     {
         return Identifier.of(ModID(), path);
     }

     /**
      * Constructs a vanilla `Identifier` for the given path.
      * This method creates an identifier that is used to reference
      * resources within the vanilla Minecraft environment. It takes
      * a path string and returns an identifier that is recognized
      * by Minecraft, ensuring proper resource references for
      * compatibility with the vanilla game.
      *
      * @param path The path string to be used for creating the vanilla identifier.
      * @return A new `Identifier` instance created from the specified path.
      */
     @NotNull
     public Identifier vanillaID(@NotNull String path)
     {
         return Identifier.ofVanilla(path);
     }

     /**
      * Constructs a generic `Identifier` for the given path.
      * This method creates an identifier that can be used to reference
      * resources in the context of the Minecraft mod or any other
      * identifier needed, ensuring flexibility in how identifiers are created
      * based on the provided path string.
      *
      * @param path The path string to be used for creating the identifier.
      * @return A new `Identifier` instance created from the specified path.
      */
     @NotNull
     public Identifier idOf(@NotNull String path)
     {
         return Identifier.of(path);
     }

     /**
      * Translates a key into a `MutableText` object using the mod's localization system.
      * This method appends the mod's ID to the provided key to create a fully qualified
      * translation key. It supports additional parameters for dynamic text replacement in
      * the translated string, making it useful for displaying user-facing text in the mod.
      *
      * @param key The translation key to be used for looking up the localized string.
      * @param params Optional parameters for dynamic text replacement in the translated string.
      * @return A `MutableText` object representing the translated string.
      */
     public MutableText translate(String key, Object... params)
     {
         return Text.translatable(ModID() + "." + key, params);
     }

     /**
      * Translates a container-specific key into a `MutableText` object using the mod's localization system.
      * This method appends the mod's ID and the "container" prefix to the provided key to create a fully
      * qualified translation key specifically for container-related text. It supports additional parameters
      * for dynamic text replacement in the translated string, making it useful for displaying user-facing
      * text for containers in the mod.
      *
      * @param key    The translation key to be used for looking up the localized string for a container.
      * @param params Optional parameters for dynamic text replacement in the translated string.
      *
      * @return A `MutableText` object representing the translated container string.
      */
     public MutableText translateContainer(String key, Object... params)
     {
         return Text.translatable(ModID() + ".container." + key, params);
     }

     /**
      * Creates a `TagKey` for a specific block tag using the provided name.
      * This method takes a string name and constructs a TagKey that refers
      * to a tag associated with blocks in the Minecraft registry. It is
      * intended to facilitate the creation of custom tags for blocks
      * within the mod, ensuring that the tags are properly registered
      * and can be referenced throughout the mod's code.
      *
      * @param name The name of the tag to be created.
      *
      * @return A `TagKey` instance representing the specified block tag.
      */
     protected TagKey<Block> createBlockTag(String name)
     {
         return TagKey.of(RegistryKeys.BLOCK, identifier(name));
     }

     /**
      * Creates a `TagKey` for a common block tag using the provided name.
      * This method takes a string name and constructs a TagKey that refers
      * to a commonly used tag associated with blocks in the Minecraft registry.
      * It ensures that the tag is registered under the "c" prefix, allowing
      * for easier identification of common tags used throughout the mod.
      *
      * @param name The name of the common tag to be created.
      *
      * @return A `TagKey` instance representing the specified common block tag.
      */
     protected TagKey<Block> createBlockCommonTag(String name)
     {
         return TagKey.of(RegistryKeys.BLOCK, Identifier.tryParse("c", name));
     }

     /**
      * Creates a `TagKey` for a specific item tag using the provided name.
      * This method takes a string name and constructs a TagKey that refers
      * to a tag associated with items in the Minecraft registry. It is
      * intended to facilitate the creation of custom tags for items
      * within the mod, ensuring that the tags are properly registered
      * and can be referenced throughout the mod's code.
      *
      * @param name The name of the tag to be created.
      *
      * @return A `TagKey` instance representing the specified item tag.
      */
     protected TagKey<Item> createItemTag(String name)
     {
         return TagKey.of(RegistryKeys.ITEM, identifier(name));
     }

     /**
      * Creates a `TagKey` for a common item tag using the provided name.
      * This method takes a string name and constructs a TagKey that refers
      * to a commonly used tag associated with items in the Minecraft registry.
      * It ensures that the tag is registered under the "c" prefix, allowing
      * for easier identification of common tags used throughout the mod.
      *
      * @param name The name of the common tag to be created.
      *
      * @return A `TagKey` instance representing the specified common item tag.
      */
     protected TagKey<Item> createItemCommonTag(String name)
     {
         return TagKey.of(RegistryKeys.ITEM, Identifier.tryParse("c", name));
     }

     /**
      * Creates a `TagKey` for a specific entity tag using the provided name.
      * This method takes a string name and constructs a TagKey that refers
      * to a tag associated with entity types in the Minecraft registry.
      * It is intended to facilitate the creation of custom tags for entities
      * within the mod, ensuring that the tags are properly registered
      * and can be referenced throughout the mod's code.
      *
      * @param name The name of the tag to be created.
      * @return A `TagKey` instance representing the specified entity tag.
      */
     protected TagKey<EntityType<?>> createEntityTag(String name)
     {
         return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier(name));
     }

     /**
      * Creates a `TagKey` for a common entity tag using the provided name.
      * This method takes a string name and constructs a TagKey that refers
      * to a commonly used tag associated with entity types in the Minecraft registry.
      * It ensures that the tag is registered under the "c" prefix, allowing
      * for easier identification of common tags used throughout the mod.
      *
      * @param name The name of the common tag to be created.
      *
      * @return A `TagKey` instance representing the specified common entity tag.
      */
     protected TagKey<EntityType<?>> createEntityCommonTag(String name)
     {
         return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.tryParse("c", name));
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * energy-related data within the application.
      *
      * @return a {@code String} representing the keyword for energy data storage.
      */
     public String energyAmountKey()
     {
         return this.modId + BEKeys.ENERGY_AMOUNT;
     }


     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * energy-related data within the application.
      *
      * @return a {@code String} representing the keyword for energy storage capacity.
      */
     public String energyCapacityKey()
     {
         return this.modId + BEKeys.ENERGY_CAPACITY;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * energy-related data within the application.
      *
      * @return a {@code String} representing the keyword for energy data presentation.
      */
     public String hasEnergyKey()
     {
         return this.modId + BEKeys.HAS_ENERGY;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * fluid-related data within the application.
      *
      * @return a {@code String} representing the keyword for fluid data storage.
      */
     public String fluidAmountKey()
     {
         return this.modId + BEKeys.FLUID_AMOUNT;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * fluid-related data within the application.
      *
      * @return a {@code String} representing the keyword for fluid storage capacity.
      */
     public String fluidCapacityKey()
     {
         return this.modId + BEKeys.FLUID_CAPACITY;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * fluid-related data within the application.
      *
      * @return a {@code String} representing the keyword for fluid data presentation.
      */
     public String hasFluidKey()
     {
         return this.modId + BEKeys.HAS_FLUID;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * progress-related data within the application.
      *
      * @return a {@code String} representing the keyword for crafting progress.
      */
     public String progressAmountKey()
     {
         return this.modId + BEKeys.PROGRESS_AMOUNT;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * progress-related data within the application.
      *
      * @return a {@code String} representing the keyword for maximum crafting progress.
      */
     public String maxProgressKey()
     {
         return this.modId + BEKeys.PROGRESS_MAX;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * progress-related data within the application.
      *
      * @return a {@code String} representing the keyword for remaining cooldown.
      */
     public String cooldownAmountKey()
     {
         return this.modId + BEKeys.COOLDOWN_AMOUNT;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * progress-related data within the application.
      *
      * @return a {@code String} representing the keyword for maximum cooldown.
      */
     public String maxCooldownKey()
     {
         return this.modId + BEKeys.COOLDOWN_MAX;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * progress-related data within the application.
      *
      * @return a {@code String} representing the keyword for burning progress.
      */
     public String burnAmountKey()
     {
         return this.modId + BEKeys.BURN_AMOUNT;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * progress-related data within the application.
      *
      * @return a {@code String} representing the keyword for maximum burning progress.
      */
     public String maxBurnKey()
     {
         return this.modId + BEKeys.BURN_MAX;
     }

     /**
      * Returns a keyword string that is used for saving information.
      * This keyword acts as an identifier for storing and retrieving
      * inventory-related data within the application.
      *
      * @return a {@code String} representing the keyword for inventory presentation.
      */
     public String hasInventoryKey()
     {
         return this.modId + BEKeys.HAS_INVENTORY;
     }
 }
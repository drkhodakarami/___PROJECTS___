package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.utils.BaseHelper;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class ArmorHelper
{
    public static ArmorMaterial getArmorMaterial(String modID, String name, int durability, int bootDefence, int leggingsDefence, int chestplateDefence, int helmetDefence,
                                                 int bodyDefence, int enchantmentValue, RegistryEntry<SoundEvent> equipSound, float toughness,
                                                 float knockbackResistance, TagKey<Item> repairIngredient)
    {
        RegistryKey<Registry<EquipmentAsset>> equipmentAssetKey = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
        RegistryKey<EquipmentAsset> key = RegistryKey.of(equipmentAssetKey, BaseHelper.identifier(modID, name));
        return new ArmorMaterial(durability,
                                 Util.make(new EnumMap<>(EquipmentType.class),
                                            (map) ->
                                                           {
                                                               map.put(EquipmentType.BOOTS, bootDefence);
                                                               map.put(EquipmentType.LEGGINGS, leggingsDefence);
                                                               map.put(EquipmentType.CHESTPLATE, chestplateDefence);
                                                               map.put(EquipmentType.HELMET, helmetDefence);
                                                               map.put(EquipmentType.BODY, bodyDefence);
                                                           }),
                                 enchantmentValue, equipSound,
                                 toughness, knockbackResistance, repairIngredient,
                                 key);
    }

    public static void generateAllArmorModels(String modID, ItemModelGenerator generator, Item[] armors, ArmorMaterial material)
    {
        EquipmentType slot;

        for (Item armor : armors)
            generateArmorModel(modID, generator, armor, material);
    }

    public static void generateArmorModel(String modID, ItemModelGenerator generator, Item armor, ArmorMaterial material)
    {
        generateArmorModel(modID, generator, armor, material, false);
    }

    public static void generateArmorModel(String modID, ItemModelGenerator generator, Item armor, ArmorMaterial material, boolean dyeable)
    {
        Identifier id = material.assetId().getValue();
        String name = Registries.ITEM.getId(armor).getPath();
        RegistryKey<Registry<EquipmentAsset>> equipmentAssetKey = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
        RegistryKey<EquipmentAsset> key = RegistryKey.of(equipmentAssetKey, BaseHelper.identifier(modID, name));
        generator.registerArmor(armor, key, id, dyeable);
    }

    public static EquipmentModel buildHumanoid(String modID, String name)
    {
        return EquipmentModel.builder().addHumanoidLayers(BaseHelper.identifier(modID, name)).build();
    }

    public static EquipmentModel buildHumanoidAndHorse(String modID, String name)
    {
        return EquipmentModel.builder()
                             .addHumanoidLayers(BaseHelper.identifier(modID, name))
                .addLayers(EquipmentModel.LayerType.HORSE_BODY,
                           EquipmentModel.Layer.createWithLeatherColor(BaseHelper.identifier(modID, name), false))
                             .build();
    }
}
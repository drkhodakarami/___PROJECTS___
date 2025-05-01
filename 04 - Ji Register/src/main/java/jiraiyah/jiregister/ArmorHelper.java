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

package jiraiyah.jiregister;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.utils.BaseHelper;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.component.Component;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class ArmorHelper
{


    public static Map<String, Identifier> SlotToArmorNames = new HashMap<>();

    static
    {

        SlotToArmorNames.put("head", ItemModelGenerator.HELMET_TRIM_ID_PREFIX);
        SlotToArmorNames.put("chest", ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX);
        SlotToArmorNames.put("legs", ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX);
        SlotToArmorNames.put("feet", ItemModelGenerator.BOOTS_TRIM_ID_PREFIX);
        SlotToArmorNames.put("body", ItemModelGenerator.getTrimAssetIdPrefix("body"));
    }

    public static ArmorMaterial getArmorMaterial(String modID, String name, int durability, int bootDefence, int leggingsDefence, int chestplateDefence, int helmetDefence,
                                                 int bodyDefence, int enchantmentValue, RegistryEntry<SoundEvent> equipSound, float toughness,
                                                 float knockbackResistance, TagKey<Item> repairIngredient)
    {
        RegistryKey<EquipmentAsset> key = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, BaseHelper.identifier(modID, name));
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

        //TODO: Explain all of this
        Component<EquippableComponent> component = armor.getComponents().getTyped(DataComponentTypes.EQUIPPABLE);
        if (component == null)
            throw new IllegalArgumentException("The item " + armor.getName() + " does not have equippable component");
        Identifier TrimID = SlotToArmorNames.get(component.value().slot().getName());
        String name = Registries.ITEM.getId(armor).getPath();
        RegistryKey<EquipmentAsset> key = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, BaseHelper.identifier(modID, name));
        generator.registerArmor(armor, key, TrimID, dyeable);
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
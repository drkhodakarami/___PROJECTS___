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
import jiraiyah.jiregister.factory.IToolFactory;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class JiItemRegister
{
    private final String modId;

    public JiItemRegister(String mod_ID)
    {
        this.modId = mod_ID;
    }

    public Item register(String name)
    {
        return register(name, Item::new);
    }

    public Item register(String name, Item.Settings settings)
    {
        return register(name, settings, Item::new);
    }

    public Item register(String name, int stackCount)
    {
        return register(name, stackCount, Item::new);
    }

    public Item register(String name, int stackCount, Item.Settings settings)
    {
        return register(name, stackCount, settings, Item::new);
    }

    public <R extends Item> R register(String name, Function<Item.Settings, R> factory)
    {
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(new Item.Settings().registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public <R extends Item> R register(String name, int stackCount, Function<Item.Settings, R> factory)
    {
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(new Item.Settings().registryKey(key). maxCount(stackCount));
        return Registry.register(Registries.ITEM, key, item);
    }

    public <R extends Item> R register(String name, Item.Settings settings, Function<Item.Settings, R> factory)
    {
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public <R extends Item> R register(String name, int stackCount, Item.Settings settings, Function<Item.Settings, R> factory)
    {
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(settings.registryKey(key). maxCount(stackCount));
        return Registry.register(Registries.ITEM, key, item);
    }

    public Item registerAxe(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Settings().axe(material, attackDamage, attackSpeed), Item::new);
    }

    public Item registerHoe(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Settings().hoe(material, attackDamage, attackSpeed), Item::new);
    }

    public Item registerPickaxe(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Settings().pickaxe(material, attackDamage, attackSpeed), Item::new);
    }

    public Item registerShovel(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Settings().shovel(material, attackDamage, attackSpeed), Item::new);
    }

    public Item registerSword(String name, ToolMaterial material, float attackDamage, float attackSpeed)
    {
        return register(name, new Item.Settings().sword(material, attackDamage, attackSpeed), Item::new);
    }

    public <R extends Item> R registerTool(String name, ToolMaterial material, float attackDamage, float attackSpeed,
                                           IToolFactory<Item.Settings, R> factory)
    {
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(material, attackDamage, attackSpeed, new Item.Settings().registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public <R extends Item> R registerTool(String name, ToolMaterial material, float attackDamage, float attackSpeed,
                                           Item.Settings settings, IToolFactory<Item.Settings, R> factory)
    {
        RegistryKey<Item> key = BaseHelper.getKey(this.modId, name, RegistryKeys.ITEM);
        R item = factory.apply(material, attackDamage, attackSpeed, settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public Item registerArmor(String name, ArmorMaterial material, EquipmentType equipment)
    {
        return register(name, new Item.Settings().armor(material, equipment), Item::new);
    }

    public Item registerArmor(String name, ArmorMaterial material, EquipmentType equipment, Item.Settings settings)
    {
        return register(name, settings.armor(material, equipment), Item::new);
    }

    public Item registerSnackFood(String name, int stackCount, int nutrition, float saturation)
    {
        return register(name, stackCount,
                        new Item.Settings()
                                            .food(new FoodComponent.Builder()
                                                          .nutrition(nutrition)
                                                          .saturationModifier(saturation)
                                                          .alwaysEdible()
                                                          .build()));
    }

    public Item registerFood(String name, int stackCount, int nutrition, float saturation)
    {
        return register(name, stackCount,
                        new Item.Settings()
                                .food(new FoodComponent.Builder()
                                              .nutrition(nutrition)
                                              .saturationModifier(saturation)
                                              .build()));
    }
}
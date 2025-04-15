package jiraiyah.ultraio.registry;

import jiraiyah.jiregister.ArmorHelper;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.sound.SoundEvents;

import static jiraiyah.ultraio.Main.*;

public class ModArmorMaterials
{
    public static ArmorMaterial AMETHYST = ArmorHelper.getArmorMaterial(ModID, "amethyst",
                                                            20,
                                                            1, 5, 7, 3, 5,
                                                            20,
                     SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5f, 0.05f,
                     REFERENCE.REPAIRS_AMETHYST_ARMOR);
    public static ArmorMaterial CITRINE = ArmorHelper.getArmorMaterial(ModID, "citrine",
                                                           30,
                                                           3, 6, 8, 3, 7,
                                                           10,
                                                           SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.05f,
                                                           REFERENCE.REPAIRS_CITRINE_ARMOR);
    public static ArmorMaterial COPPER = ArmorHelper.getArmorMaterial(ModID, "copper",
                                                          25,
                                                          2, 5, 6, 2, 7,
                                                          9,
                                                          SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f,
                                                          REFERENCE.REPAIRS_COPPER_ARMOR);
    public static ArmorMaterial EMERALD = ArmorHelper.getArmorMaterial(ModID, "emerald",
                                                           15,
                                                           1, 5, 7, 2, 7,
                                                           20,
                                                           SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5f, 0.05f,
                                                           REFERENCE.REPAIRS_EMERALD_ARMOR);
    public static ArmorMaterial ENDERITE = ArmorHelper.getArmorMaterial(ModID, "enderite",
                                                            42,
                                                            3, 6, 8, 3, 15,
                                                            30,
                                                            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4.0f, 0.2f,
                                                            REFERENCE.REPAIRS_ENDERITE_ARMOR);
    public static ArmorMaterial RUBY = ArmorHelper.getArmorMaterial(ModID, "ruby",
                                                        35,
                                                        3, 6, 8, 3, 7,
                                                        10,
                                                        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.05f,
                                                        REFERENCE.REPAIRS_RUBY_ARMOR);
    public static ArmorMaterial SAPPHIRE = ArmorHelper.getArmorMaterial(ModID, "sapphire",
                                                            35,
                                                            3, 6, 8, 3, 7,
                                                            10,
                                                            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.05f,
                                                            REFERENCE.REPAIRS_SAPPHIRE_ARMOR);

    public ModArmorMaterials()
    {
        throw new AssertionError("This class should not be instantiated");
    }

    public static void init()
    {
        LOGGER.logArmorMaterialInit();

        //I: durability: Leather: 5, Chain: 15, Iron 15, Gold: 7, Diamond: 33, TurtleScute: 25, Netherite: 37, ArmadilloScute: 4
        //J: enchantability: Leather: 15, Chain: 12, IroL 9, Gold: 25, Diamond: 10, TurtleScute: 9, Netherite: 15, ArmadilloScute: 10
        //F: Toughness: Leather: 0.0f, Chain: 0.0f, Iron 0.0f, Gold: 0.0f, Diamond: 2.0f, TurtleScute: 0.0f, Netherite: 3.0f, ArmadilloScute: 0.0f
        //G: Knockback Resistance: Leather: 0.0f, Chain: 0.0f, Iron 0.0f, Gold: 0.0f, Diamond: 0.0f, TurtleScute: 0.0f, Netherite: 0.1f, ArmadilloScute: 0.0f
        //Enchantability can't be 0 any more, take a look at Item Tag Provider Datagen
    }
}
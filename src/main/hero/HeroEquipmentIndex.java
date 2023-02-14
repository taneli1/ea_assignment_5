package main.hero;

import main.equipment.items.Item;
import main.equipment.items.armor.Armor;
import main.equipment.items.armor.ArmorType;
import main.equipment.items.weapon.Weapon;
import main.equipment.items.weapon.WeaponType;

import java.util.List;

import static main.equipment.items.armor.ArmorType.*;
import static main.equipment.items.weapon.WeaponType.*;

/**
 * Contains the information on which classes can equip what.
 */
public class HeroEquipmentIndex {

    public static boolean canEquip(HeroClass heroClass, Item item) {
        if (item instanceof Armor) {
            ArmorType type = ((Armor) item).armorType;
            return HeroEquipmentIndex.validArmorTypes(heroClass).contains(type);
        }

        if (item instanceof Weapon) {
            WeaponType type = ((Weapon) item).weaponType;
            return HeroEquipmentIndex.validWeaponTypes(heroClass).contains(type);
        }

        return false;
    }

    public static List<ArmorType> validArmorTypes(HeroClass forClass) {
        return switch (forClass) {
            case MAGE -> List.of(CLOTH);
            case RANGER, ROGUE -> List.of(LEATHER, MAIL);
            case WARRIOR -> List.of(MAIL, PLATE);
        };
    }

    public static List<WeaponType> validWeaponTypes(HeroClass forClass) {
        return switch (forClass) {
            case MAGE -> List.of(STAFF, WAND);
            case RANGER -> List.of(BOW);
            case ROGUE -> List.of(DAGGER, SWORD);
            case WARRIOR -> List.of(AXE, HAMMER, SWORD);
        };
    }
}

package main.hero;

import main.equipment.items.armor.ArmorType;
import main.equipment.items.weapon.WeaponType;

import java.util.List;

import static main.equipment.items.armor.ArmorType.*;
import static main.equipment.items.weapon.WeaponType.*;

/**
 * Contains the information on which classes can equip what.
 */
public class HeroEquipmentIndex {
    public static List<ArmorType> validArmorTypes(HeroClass forClass) {
        return switch (forClass) {
            case Mage -> List.of(Cloth);
            case Ranger, Rogue -> List.of(Leather, Mail);
            case Warrior -> List.of(Mail, Plate);
        };
    }

    public static List<WeaponType> validWeaponTypes(HeroClass forClass) {
        return switch (forClass) {
            case Mage -> List.of(Staff, Wand);
            case Ranger -> List.of(Bow);
            case Rogue -> List.of(Dagger, Sword);
            case Warrior -> List.of(Axe, Hammer, Sword);
        };
    }
}

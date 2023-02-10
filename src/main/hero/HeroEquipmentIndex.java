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
            case MAGE -> List.of(Cloth);
            case RANGER, ROGUE -> List.of(Leather, Mail);
            case WARRIOR -> List.of(Mail, Plate);
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

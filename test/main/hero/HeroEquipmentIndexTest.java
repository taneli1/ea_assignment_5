package main.hero;

import main.equipment.items.armor.ArmorType;
import main.equipment.items.weapon.WeaponType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroEquipmentIndexTest {

    @Test
    void validArmorTypes_forMage() {
        assertEquals(List.of(ArmorType.CLOTH), HeroEquipmentIndex.validArmorTypes(HeroClass.MAGE));
    }

    @Test
    void validArmorTypes_forRanger() {
        assertEquals(List.of(ArmorType.LEATHER, ArmorType.MAIL), HeroEquipmentIndex.validArmorTypes(HeroClass.RANGER));
    }

    @Test
    void validArmorTypes_forRogue() {
        assertEquals(List.of(ArmorType.LEATHER, ArmorType.MAIL), HeroEquipmentIndex.validArmorTypes(HeroClass.ROGUE));
    }

    @Test
    void validArmorTypes_forWarrior() {
        assertEquals(List.of(ArmorType.MAIL, ArmorType.PLATE), HeroEquipmentIndex.validArmorTypes(HeroClass.WARRIOR));
    }

    @Test
    void validWeaponTypes_forMage() {
        assertEquals(List.of(WeaponType.STAFF, WeaponType.WAND), HeroEquipmentIndex.validWeaponTypes(HeroClass.MAGE));
    }

    @Test
    void validWeaponTypes_forRanger() {
        assertEquals(List.of(WeaponType.BOW), HeroEquipmentIndex.validWeaponTypes(HeroClass.RANGER));
    }

    @Test
    void validWeaponTypes_forRogue() {
        assertEquals(List.of(WeaponType.DAGGER, WeaponType.SWORD), HeroEquipmentIndex.validWeaponTypes(HeroClass.ROGUE));
    }

    @Test
    void validWeaponTypes_forWarrior() {
        assertEquals(List.of(WeaponType.AXE, WeaponType.HAMMER, WeaponType.SWORD), HeroEquipmentIndex.validWeaponTypes(HeroClass.WARRIOR));
    }
}
package main.hero;

import main.attributes.StatAttributes;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.exceptions.InvalidWeaponException;
import main.equipment.items.armor.Armor;
import main.equipment.items.armor.ArmorFactory;
import main.equipment.items.weapon.Weapon;
import main.equipment.items.weapon.WeaponFactory;
import main.equipment.items.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroIntegrationTest {

    Hero hero;
    Weapon levelFiveWeapon = new Weapon("Weapon", 5, WeaponType.AXE, 5);

    @BeforeEach
    void setup() {
        hero = HeroFactory.buildHero("Test", HeroClass.WARRIOR);
    }

    @Test
    void hero_getsInitialized_withCorrectValues_forWarrior() {
        StatAttributes att = hero.getTotalAttributes();

        assertEquals(1, hero.getLevel());
        assertEquals(1, hero.getDamage());
        assertEquals(5, att.getStr());
        assertEquals(2, att.getDex());
        assertEquals(1, att.getInt());
    }

    @Test
    void equip_tooHighLevelItem_throws() {
        assertThrows(InvalidItemException.class, () -> {
            hero.equip(levelFiveWeapon);
        });
    }

    @Test
    void levelUp_works_toAllowPreviouslyInvalidItems_toBeEquipped() {
        hero.levelUp();
        hero.levelUp();
        hero.levelUp();
        hero.levelUp();

        assertDoesNotThrow(() -> hero.equip(levelFiveWeapon));
    }

    @Test
    void equip_weaponOfAnotherClass_throws() {
        Weapon staff = WeaponFactory.testStaff();
        assertThrows(InvalidWeaponException.class, () -> {
            hero.equip(staff);
        });
    }

    @Test
    void equippedItems_areUsedInTotalAttributes() throws Exception {
        Armor head = ArmorFactory.testHead();
        Armor legs = ArmorFactory.testLegs();
        Armor chest = ArmorFactory.testChest();
        hero.equip(head);
        hero.equip(legs);
        hero.equip(chest);

        StatAttributes att = hero.getTotalAttributes();

        // Warrior lvl 1 + 3 x 1 for each from the test armors
        assertEquals(8, att.getStr());
        assertEquals(5, att.getDex());
        assertEquals(4, att.getInt());
    }

    @Test
    void equippingItems_multipleTimes_worksAsExpected() throws Exception {
        Armor head = ArmorFactory.testHead();
        Armor head2 = ArmorFactory.testHead();
        Armor head3 = ArmorFactory.testHead();

        hero.equip(head);
        hero.equip(head2);
        hero.equip(head3);

        StatAttributes att = hero.getTotalAttributes();

        // Warrior lvl 1 + one testHead()
        assertEquals(6, att.getStr());
        assertEquals(3, att.getDex());
        assertEquals(2, att.getInt());
    }

    @Test
    void equippedItems_affectDamage() {
        Armor head = ArmorFactory.testHead();
        Armor legs = ArmorFactory.testLegs();
        Armor chest = ArmorFactory.testChest();
        Weapon axe = WeaponFactory.testAxe(); // 100 dmg

        // TODO
    }
}
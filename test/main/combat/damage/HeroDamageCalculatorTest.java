package main.combat.damage;

import main.attributes.StatAttributeHolder;
import main.attributes.StatAttributes;
import main.attributes.hero.HeroAttributeIndex;
import main.attributes.hero.HeroAttributeProvider;
import main.equipment.ItemUser;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.items.Item;
import main.equipment.items.weapon.Weapon;
import main.equipment.items.weapon.WeaponType;
import main.equipment.manager.EquipmentManager;
import main.equipment.manager.ItemUserEquipmentManager;
import main.hero.Hero;
import main.hero.HeroClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroDamageCalculatorTest {

    HeroDamageCalculator calc = new HeroDamageCalculator();
    StatAttributes testAtt = new StatAttributeHolder(100, 100, 100);
    HeroAttributeProvider testProvider = new HeroAttributeProvider() {
        @Override
        public StatAttributes resolveLevelAttributes(HeroClass heroClass, int level) {
            return testAtt;
        }
    };

    EquipmentManager testManager = new EquipmentManager() {
        @Override
        public void equip(ItemUser user, Item item) {
            throw new RuntimeException();
        }

        @Override
        public StatAttributes getEquippedArmorAttributes() {
            return testAtt;
        }

        @Override
        public Weapon getEquippedWeapon() {
            throw new RuntimeException();
        }
    };

    @Test
    void resolveDamageFormula_worksAsExpected() {
        Hero hero = new Hero(null, 0, HeroClass.MAGE, testManager, testProvider, null);
        Weapon wp = new Weapon(null, 0, null, 10);

        int damage = calc.resolveDamage(hero, wp);

        assertEquals(30, damage);
    }
}
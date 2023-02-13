package main.hero;

import main.attributes.StatAttributes;
import main.attributes.hero.HeroAttributeProvider;
import main.combat.damage.DamageCalculator;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.items.Item;
import main.equipment.items.ItemSlot;
import main.equipment.items.armor.Armor;
import main.equipment.items.armor.ArmorType;
import main.equipment.items.weapon.Weapon;
import main.equipment.manager.HeroEquipmentManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Hero hero;

    @BeforeEach
    void setup() {
        HeroEquipmentManager manager = new HeroEquipmentManager();

        // Returns the hero level for each attribute
        HeroAttributeProvider provider = new HeroAttributeProvider() {
            @Override
            public StatAttributes resolveLevelAttributes(HeroClass heroClass, int level) {
                return new StatAttributes() {
                    @Override
                    public int getStr() {
                        return level;
                    }

                    @Override
                    public int getDex() {
                        return level;
                    }

                    @Override
                    public int getInt() {
                        return level;
                    }
                };
            }
        };

        // Returns hero level as the damage
        DamageCalculator<Hero> calc = new DamageCalculator<Hero>() {
            @Override
            public int resolveDamage(Hero unit, Weapon weapon) {
                return unit.getLevel();
            }
        };

        hero = new Hero("Test", 1, HeroClass.RANGER, manager, provider, calc);
        manager.bind(hero);
    }

    @Test
    void heroClass_returned() {
        assertEquals(hero.getHeroClass(), HeroClass.RANGER);
    }

    @Test
    void levelUp_updates_heroLevel() {
        hero.levelUp();
        assertEquals(2, hero.getLevel());
    }

    @Test
    void levelUp_updates_totalAttributes() {
        assertEquals(1, hero.getTotalAttributes().getDex());
        hero.levelUp();
        assertEquals(2, hero.getTotalAttributes().getDex());
    }

    @Test
    void damage_ok() {
        assertEquals(1, hero.getDamage());
    }

    @Test
    void damage_recalculated_withLevelUp() {
        hero.levelUp();
        assertEquals(2, hero.getDamage());
    }

    @Test
    void display_returns_desiredInfo() {
        String display = hero.display();
        assertTrue(display.contains("Name: Test"));
        assertTrue(display.contains("Damage: 1"));
        assertTrue(display.contains("Class: RANGER"));
        assertTrue(display.contains("Total Strength: 1"));
        assertTrue(display.contains("Total Dexterity: 1"));
        assertTrue(display.contains("Total Intelligence: 1"));
        assertTrue(display.contains("Damage: 1"));
    }

    @Test
    void equipArmor_changes_totalAttributes() throws InvalidItemException {
        Item item = new Armor("", 1, ItemSlot.BODY, ArmorType.LEATHER, new StatAttributes() {
            @Override
            public int getStr() {
                return 99;
            }

            @Override
            public int getDex() {
                return 0;
            }

            @Override
            public int getInt() {
                return 0;
            }
        });
        hero.equip(item);
        assertEquals(100, hero.getTotalAttributes().getStr());
    }
}
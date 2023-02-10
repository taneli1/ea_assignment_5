package main.hero;

import main.attributes.StatAttributes;
import main.attributes.hero.HeroAttributeProvider;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.items.Item;
import main.equipment.manager.EquipmentManager;

public class Hero {
    private final String name;
    private final HeroClass heroClass;
    private final HeroAttributeProvider provider;
    private final EquipmentManager equipmentManager;

    private int level;
    private StatAttributes levelAttributes;

    public Hero(String name, int level, HeroClass heroClass, EquipmentManager equipmentManager, HeroAttributeProvider provider) {
        this.name = name;
        this.heroClass = heroClass;
        this.provider = provider;
        this.equipmentManager = equipmentManager;

        this.level = level;
        this.levelAttributes = provider.resolveLevelAttributes(heroClass, level);
    }

    public int getLevel() {
        return this.level;
    }

    public HeroClass getHeroClass() {
        return this.heroClass;
    }

    public int getDamage() {
        return equipmentManager.getEquippedWeapon().weaponDamage;
    }

    public StatAttributes getTotalAttributes() {
        return this.levelAttributes.combine(equipmentManager.getEquippedArmorAttributes());
    }

    public String display() {
        StatAttributes total = getTotalAttributes();
        return "Name: " + name + "\n" +
                "Class: " + heroClass + "\n" +
                "Level: " + level + "\n" +
                "Total Strength: " + total.getStr() + "\n" +
                "Total Dexterity: " + total.getDex() + "\n" +
                "Total Intelligence: " + total.getInt() + "\n" +
                "Damage: " + getDamage() + "\n";
    }

    public void equip(Item item) throws InvalidItemException {
        equipmentManager.equip(item);
    }

    public void levelUp() {
        this.level = this.level + 1;
        this.levelAttributes = provider.resolveLevelAttributes(heroClass, this.level);
    }
}

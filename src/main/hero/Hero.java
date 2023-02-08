package main.hero;

import main.attributes.StatAttributes;
import main.attributes.hero.HeroAttributeProvider;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.items.Item;
import main.equipment.manager.EquipmentManager;

public abstract class Hero {
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

    public int getDamage() {
        return 1;
    }

    public StatAttributes getTotalAttributes() {
        return this.levelAttributes;
    }

    public String display() {
        return "Name: " + name + "\n" +
                "Class: " + heroClass + "\n" +
                "Level: " + level + "\n" +
                "Total Strength: " + levelAttributes.getStr() + "\n" +
                "Total Dexterity: " + levelAttributes.getDex() + "\n" +
                "Total Intelligence: " + levelAttributes.getInt() + "\n" +
                "Damage: " + 1 + "\n";
    }

    public void equip(Item item) throws InvalidItemException {
        equipmentManager.equip(item);
    }

    public void levelUp() {
        this.level = this.level + 1;
        this.levelAttributes = provider.resolveLevelAttributes(heroClass, this.level);
    }
}

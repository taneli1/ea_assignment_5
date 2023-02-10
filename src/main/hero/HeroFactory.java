package main.hero;

import main.attributes.StatAttributes;
import main.attributes.hero.HeroAttributeIndex;
import main.attributes.hero.HeroAttributeProvider;
import main.equipment.manager.HeroEquipmentManager;

public abstract class HeroFactory {

    public static Hero buildHero(String name, HeroClass heroClass) {
        HeroAttributeProvider provider = new HeroAttributeIndex();
        HeroEquipmentManager manager = new HeroEquipmentManager();
        Hero hero = new Hero(name, 20, heroClass, manager, provider);
        // Better way?
        manager.bind(hero);
        return hero;
    }
}

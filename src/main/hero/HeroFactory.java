package main.hero;

import main.attributes.hero.HeroAttributeIndex;
import main.attributes.hero.HeroAttributeProvider;
import main.combat.damage.HeroDamageCalculator;
import main.equipment.manager.ItemUserEquipmentManager;

public abstract class HeroFactory {

    public static Hero buildHero(String name, HeroClass heroClass) {
        HeroAttributeProvider provider = new HeroAttributeIndex();
        ItemUserEquipmentManager manager = new ItemUserEquipmentManager();
        HeroDamageCalculator calc = new HeroDamageCalculator();
        return new Hero(name, 1, heroClass, manager, provider, calc);
    }
}

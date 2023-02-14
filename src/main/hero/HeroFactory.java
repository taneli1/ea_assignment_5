package main.hero;

import main.attributes.hero.HeroAttributeIndex;
import main.attributes.hero.HeroAttributeProvider;
import main.combat.damage.HeroDamageCalculator;
import main.equipment.manager.HeroEquipmentManager;

public abstract class HeroFactory {

    public static Hero buildHero(String name, HeroClass heroClass) {
        HeroAttributeProvider provider = new HeroAttributeIndex();
        HeroEquipmentManager manager = new HeroEquipmentManager();
        HeroDamageCalculator calc = new HeroDamageCalculator();
        return new Hero(name, 1, heroClass, manager, provider, calc);
    }
}

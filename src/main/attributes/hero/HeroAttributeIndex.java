package main.attributes.hero;

import main.attributes.StatAttributes;
import main.hero.HeroClass;


public class HeroAttributeIndex implements HeroAttributeProvider {

    @Override
    public StatAttributes resolveLevelAttributes(HeroClass heroClass, int level) {
        return switch (heroClass) {
            case Mage -> new MageAttributes(level);
            case Ranger -> new RangerAttributes(level);
            case Rogue -> new RogueAttributes(level);
            case Warrior -> new WarriorAttributes(level);
        };
    }
}

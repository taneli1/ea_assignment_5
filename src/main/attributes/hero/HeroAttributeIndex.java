package main.attributes.hero;

import main.attributes.StatAttributes;
import main.hero.HeroClass;


public class HeroAttributeIndex implements HeroAttributeProvider {

    @Override
    public StatAttributes resolveLevelAttributes(HeroClass heroClass, int level) {
        return switch (heroClass) {
            case MAGE -> new MageAttributes(level);
            case RANGER -> new RangerAttributes(level);
            case ROGUE -> new RogueAttributes(level);
            case WARRIOR -> new WarriorAttributes(level);
        };
    }
}

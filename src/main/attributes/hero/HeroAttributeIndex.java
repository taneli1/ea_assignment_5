package main.attributes.hero;

import main.attributes.StatAttributes;
import main.hero.Hero;
import main.hero.HeroClass;
import org.w3c.dom.ranges.Range;


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

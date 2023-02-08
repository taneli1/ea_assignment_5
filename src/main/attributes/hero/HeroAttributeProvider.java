package main.attributes.hero;

import main.attributes.StatAttributes;
import main.hero.HeroClass;

public interface HeroAttributeProvider {
    /**
     * @return a StatAttribute containing the attributes for the HeroClass of a specified level.
     */
    StatAttributes resolveLevelAttributes(HeroClass heroClass, int level);
}

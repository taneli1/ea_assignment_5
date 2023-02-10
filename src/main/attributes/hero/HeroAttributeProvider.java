package main.attributes.hero;

import main.attributes.StatAttributes;
import main.hero.HeroClass;

/**
 * Able to provide StatAttributes for Heroes.
 */
public interface HeroAttributeProvider {
    /**
     * @return StatAttributes containing the attributes for the HeroClass of a specified level.
     */
    StatAttributes resolveLevelAttributes(HeroClass heroClass, int level);
}

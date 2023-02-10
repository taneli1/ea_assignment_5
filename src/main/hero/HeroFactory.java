package main.hero;

import main.attributes.StatAttributes;
import main.attributes.hero.HeroAttributeIndex;
import main.attributes.hero.HeroAttributeProvider;

public abstract class HeroFactory {

    public static void buildHero(String name, HeroClass heroClass) {
        int level = 1;
        HeroAttributeProvider provider = new HeroAttributeIndex();
    }
}

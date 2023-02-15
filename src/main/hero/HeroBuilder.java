package main.hero;

import main.attributes.hero.HeroAttributeIndex;
import main.attributes.hero.HeroAttributeProvider;
import main.combat.damage.HeroDamageCalculator;
import main.equipment.manager.ItemUserEquipmentManager;

public class HeroBuilder {
    private final HeroAttributeProvider provider = new HeroAttributeIndex();
    private final ItemUserEquipmentManager manager = new ItemUserEquipmentManager();
    private final HeroDamageCalculator calc = new HeroDamageCalculator();
    private String name;
    private HeroClass heroClass;

    public HeroBuilder() {
        this.name = "HeroName";
    }

    public HeroBuilder name(String name) {
        this.name = name;
        return this;
    }


    public HeroBuilder heroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public boolean isReady() {
        return this.heroClass != null;
    }

    public Hero build() {
        return new Hero(name, 1, heroClass, manager, provider, calc);
    }
}

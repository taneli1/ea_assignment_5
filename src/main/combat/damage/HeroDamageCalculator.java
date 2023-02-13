package main.combat.damage;

import main.attributes.StatAttributes;
import main.equipment.items.weapon.Weapon;
import main.hero.Hero;

public class HeroDamageCalculator implements DamageCalculator<Hero> {
    @Override
    public int resolveDamage(Hero unit, Weapon weapon) {
        return weapon.weaponDamage * (1 + getDamageAttribute(unit) / 100);
    }

    private int getDamageAttribute(Hero hero) {
        StatAttributes att = hero.getTotalAttributes();
        return switch (hero.getHeroClass()) {
            case MAGE -> att.getInt();
            case WARRIOR -> att.getStr();
            case ROGUE, RANGER -> att.getDex();
        };
    }
}

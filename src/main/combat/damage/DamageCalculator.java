package main.combat.damage;

import main.equipment.items.weapon.Weapon;
import main.hero.Hero;

/**
 * Resolve damage for T.
 */
public interface DamageCalculator<T> {
    int resolveDamage(T unit, Weapon weapon);
}

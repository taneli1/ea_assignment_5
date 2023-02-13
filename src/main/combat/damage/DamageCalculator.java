package main.combat.damage;

import main.equipment.items.weapon.Weapon;

/**
 * Resolve damage for T.
 */
public interface DamageCalculator<T> {
    int resolveDamage(T unit, Weapon weapon);
}

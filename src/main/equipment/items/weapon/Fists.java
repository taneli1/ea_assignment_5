package main.equipment.items.weapon;

/**
 * A 'weapon' for the cases there is no weapon equipped.
 */
public final class Fists extends Weapon {
    public Fists() {
        super("Fists", 1, WeaponType.FISTS, 1);
    }
}

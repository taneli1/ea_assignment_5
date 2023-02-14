package main.equipment.exceptions;

/**
 * Invalid weapon for HeroClass.
 */
public class InvalidWeaponException extends InvalidItemException {
    public InvalidWeaponException() {
        super("This user cannot equip this type of weapon.");
    }
}

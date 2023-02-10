package main.equipment.exceptions;

/**
 * Invalid weapon for HeroClass.
 */
public class InvalidWeaponException extends InvalidItemException {
    public InvalidWeaponException() {
        super("You cannot equip this type of weapon.");
    }
}

package main.equipment.exceptions;

public class InvalidWeaponException extends InvalidItemException {
    public InvalidWeaponException() {
        super("You cannot equip this type of weapon.");
    }
}

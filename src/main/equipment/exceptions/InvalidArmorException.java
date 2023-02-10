package main.equipment.exceptions;

/**
 * Invalid armor for HeroClass.
 */
public class InvalidArmorException extends InvalidItemException {
    public InvalidArmorException() {
        super("You cannot equip this type of armor.");
    }
}

package main.equipment.exceptions;

public class InvalidArmorException extends InvalidItemException {
    public InvalidArmorException() {
        super("You cannot equip this type of armor.");
    }
}

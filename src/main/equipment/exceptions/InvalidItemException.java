package main.equipment.exceptions;

/**
 * Generic exceptions related to items.
 */
public class InvalidItemException extends Exception {
    public InvalidItemException(String msg) {
        super(msg);
    }
}

package main.inventory;

public class InventoryException extends Exception {
    public InventoryException() {
        super("Inventory is full.");
    }
}

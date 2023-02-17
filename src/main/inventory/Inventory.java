package main.inventory;

import main.equipment.items.Item;

import java.util.List;

public interface Inventory {
    void saveItem(Item item) throws InventoryException;

    List<Item> getItems();

    int emptySlots();
}

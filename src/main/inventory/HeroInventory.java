package main.inventory;

import main.equipment.items.Item;

import java.util.List;

public class HeroInventory implements Inventory {
    @Override
    public void saveItem(Item item) throws InventoryException {

    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public int emptySlots() {
        return 0;
    }
}

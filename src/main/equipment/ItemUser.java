package main.equipment;

import main.equipment.items.Item;

/**
 * Marks an entity to be able to be used with equipment manager.
 */
public interface ItemUser {
    int getLevel();

    /**
     * @return whether the item is equipable by this entity or not.
     */
    boolean isEquipable(Item item);
}
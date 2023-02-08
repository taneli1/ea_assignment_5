package main.equipment.manager;

import main.attributes.StatAttributes;
import main.equipment.items.Item;
import main.equipment.exceptions.InvalidItemException;

public interface EquipmentManager {
    void equip(Item item) throws InvalidItemException;

    StatAttributes getTotalArmorAttributes();
}

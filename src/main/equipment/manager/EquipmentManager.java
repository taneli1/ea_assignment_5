package main.equipment.manager;

import main.attributes.StatAttributes;
import main.equipment.items.Item;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.items.weapon.Weapon;

/**
 * Manage equipped items.
 */
public interface EquipmentManager {
    void equip(Item item) throws InvalidItemException;

    StatAttributes getEquippedArmorAttributes();

    Weapon getEquippedWeapon();
}

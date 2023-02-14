package main.equipment.manager;

import main.attributes.StatAttributes;
import main.equipment.ItemUser;
import main.equipment.items.Item;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.items.weapon.Weapon;

/**
 * Manage equipped items.
 */
public interface EquipmentManager {
    void equip(ItemUser user, Item item) throws InvalidItemException;

    StatAttributes getEquippedArmorAttributes();

    Weapon getEquippedWeapon();
}

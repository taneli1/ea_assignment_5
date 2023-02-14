package main.equipment.manager;

import main.attributes.StatAttributeHolder;
import main.attributes.StatAttributes;
import main.equipment.ItemUser;
import main.equipment.exceptions.InvalidArmorException;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.exceptions.InvalidWeaponException;
import main.equipment.items.Item;
import main.equipment.items.ItemSlot;
import main.equipment.items.armor.Armor;
import main.equipment.items.weapon.Fists;
import main.equipment.items.weapon.Weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the equipment of an ItemUser.
 */
public class ItemUserEquipmentManager implements EquipmentManager {
    private static final List<ItemSlot> armorSlots = List.of(ItemSlot.BODY, ItemSlot.HEAD, ItemSlot.LEGS);
    private final Map<ItemSlot, Item> equipped = new HashMap<ItemSlot, Item>();

    @Override
    public void equip(ItemUser user, Item item) throws InvalidItemException {
        checkRequirements(user, item);
        equipped.put(item.slot, item);
    }

    private void checkRequirements(ItemUser user, Item item) throws InvalidItemException {
        boolean levelOk = user.getLevel() >= item.requiredLevel;
        if (!levelOk) {
            throw new InvalidItemException("The user does not meet the required level (%d) to equip this item.".formatted(item.requiredLevel));
        }

        boolean canEquip = user.isEquipable(item);
        if (canEquip) return;

        if (item instanceof Armor) {
            throw new InvalidArmorException();
        }
        if (item instanceof Weapon) {
            throw new InvalidWeaponException();
        }

        throw new InvalidItemException("This item cannot be equipped by the user.");
    }

    @Override
    public StatAttributes getEquippedArmorAttributes() {
        return equipped.entrySet().stream()
                .filter(it -> armorSlots.contains(it.getKey()))     // Armor instances
                .filter(it -> it.getValue() != null)                // Only slots with items
                .map(it -> ((Armor) it.getValue()).armorAttribute)  // To list of StatAttributes
                .reduce(new StatAttributeHolder(), StatAttributes::combine);
    }

    @Override
    public Weapon getEquippedWeapon() {
        Item weapon = equipped.get(ItemSlot.WEAPON);
        return weapon != null ? (Weapon) weapon : new Fists();
    }
}

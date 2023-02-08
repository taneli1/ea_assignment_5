package main.equipment.items.armor;

import main.equipment.items.ItemSlot;
import main.attributes.StatAttributes;
import main.equipment.items.Item;

public class Armor extends Item {
    public final ArmorType armorType;
    public final StatAttributes armorAttribute;

    public Armor(String name, int requiredLevel, ItemSlot slot, ArmorType armorType, StatAttributes armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorAttribute = armorAttribute;
        this.armorType = armorType;
    }
}

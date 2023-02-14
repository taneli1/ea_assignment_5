package main.equipment.items.armor;

import main.attributes.StatAttributeHolder;
import main.equipment.items.ItemSlot;

public class ArmorFactory {

    public static Armor testChest() {
        return new Armor("Chestpiece", 1, ItemSlot.BODY, ArmorType.PLATE, new StatAttributeHolder(1, 1, 1));
    }

    public static Armor testLegs() {
        return new Armor("Legwear", 1, ItemSlot.LEGS, ArmorType.PLATE, new StatAttributeHolder(1, 1, 1));
    }

    public static Armor testHead() {
        return new Armor("Headgear", 1, ItemSlot.HEAD, ArmorType.PLATE, new StatAttributeHolder(1, 1, 1));
    }
}

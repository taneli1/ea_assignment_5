package main.equipment.items.armor;

import main.attributes.StatAttributeHolder;
import main.equipment.items.ItemSlot;

public class ArmorFactory {

    public static Armor chest() {
        return new Armor("Chestpiece", 1, ItemSlot.BODY, ArmorType.CLOTH, new StatAttributeHolder(1, 1, 1));
    }

    public static Armor legs() {
        return new Armor("Legs", 1, ItemSlot.LEGS, ArmorType.CLOTH, new StatAttributeHolder(1, 1, 1));
    }

    public static Armor head() {
        return new Armor("Head", 1, ItemSlot.HEAD, ArmorType.CLOTH, new StatAttributeHolder(1, 1, 1));
    }
}

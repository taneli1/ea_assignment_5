package main.equipment.items.armor;

import main.attributes.StatAttributeHolder;
import main.equipment.items.ItemSlot;

public class ArmorFactory {

    public static Armor chest() {
        return new Armor("Chestpiece", 1, ItemSlot.Body, ArmorType.Cloth, new StatAttributeHolder(1, 1, 1));
    }

    public static Armor legs() {
        return new Armor("Legs", 1, ItemSlot.Legs, ArmorType.Cloth, new StatAttributeHolder(1, 1, 1));
    }

    public static Armor head() {
        return new Armor("Head", 1, ItemSlot.Head, ArmorType.Cloth, new StatAttributeHolder(1, 1, 1));
    }
}

package main.equipment.items;

public abstract class Item {
    public final String name;
    public final int requiredLevel;
    public final ItemSlot slot;

    public Item(String name, int requiredLevel, ItemSlot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }
}

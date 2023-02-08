package main.equipment.items.weapon;

import main.equipment.items.ItemSlot;
import main.equipment.items.Item;

public class Weapon extends Item {
    public final WeaponType weaponType;
    public final int weaponDamage;

    public Weapon(String name, int requiredLevel, WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, ItemSlot.Weapon);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }
}


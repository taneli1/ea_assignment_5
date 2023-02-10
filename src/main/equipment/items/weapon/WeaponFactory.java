package main.equipment.items.weapon;

public class WeaponFactory {
    public static Weapon staff() {
        return new Weapon("Staff", 1, WeaponType.STAFF, 20);
    }
}

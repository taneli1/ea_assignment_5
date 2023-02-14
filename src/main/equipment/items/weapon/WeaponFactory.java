package main.equipment.items.weapon;

public class WeaponFactory {
    public static Weapon testStaff() {
        return new Weapon("Staff", 1, WeaponType.STAFF, 1);
    }

    public static Weapon testAxe() {
        return new Weapon("Axe", 1, WeaponType.AXE, 1);
    }
}

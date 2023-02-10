package main.equipment.manager;

import main.attributes.StatAttributeHolder;
import main.attributes.StatAttributes;
import main.equipment.exceptions.InvalidArmorException;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.exceptions.InvalidWeaponException;
import main.equipment.items.Item;
import main.equipment.items.ItemSlot;
import main.equipment.items.armor.Armor;
import main.equipment.items.armor.ArmorType;
import main.equipment.items.weapon.Fists;
import main.equipment.items.weapon.Weapon;
import main.equipment.items.weapon.WeaponType;
import main.hero.Hero;
import main.hero.HeroClass;
import main.hero.HeroEquipmentIndex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the equipment of a hero.
 */
public class HeroEquipmentManager implements EquipmentManager {
    private static final List<ItemSlot> armorSlots = List.of(ItemSlot.Body, ItemSlot.Head, ItemSlot.Legs);
    private final Map<ItemSlot, Item> equipped = new HashMap<ItemSlot, Item>();

    private Hero hero;

    public void bind(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void equip(Item item) throws InvalidItemException {
        checkIsBound();
        checkRequirements(item);
        equipped.put(item.slot, item);
    }

    private void checkIsBound() {
        if (this.hero == null) {
            throw new RuntimeException("HeroEquipmentManager requires an instance of a Hero to be bound.");
        }
    }

    private void checkRequirements(Item item) throws InvalidItemException {
        boolean levelOk = hero.getLevel() >= item.requiredLevel;
        if (!levelOk) {
            throw new InvalidItemException("You do not meet the required level (%d) to equip this item.".formatted(item.requiredLevel));
        }

        HeroClass hc = hero.getHeroClass();
        if (item instanceof Armor) {
            ArmorType type = ((Armor) item).armorType;
            boolean canEqp = HeroEquipmentIndex.validArmorTypes(hc).contains(type);
            if (!canEqp) throw new InvalidArmorException();
        }

        if (item instanceof Weapon) {
            WeaponType type = ((Weapon) item).weaponType;
            boolean canEqp = HeroEquipmentIndex.validWeaponTypes(hc).contains(type);
            if (!canEqp) throw new InvalidWeaponException();
        }
    }


    @Override
    public StatAttributes getEquippedArmorAttributes() {
        checkIsBound();

        return equipped.entrySet().stream()
                .filter(it -> armorSlots.contains(it.getKey()))     // Armor instances
                .filter(it -> it.getValue() != null)                // Only slots with items
                .map(it -> ((Armor) it.getValue()).armorAttribute)  // To list of StatAttributes
                .reduce(new StatAttributeHolder(), StatAttributes::combine);
    }

    @Override
    public Weapon getEquippedWeapon() {
        Item weapon = equipped.get(ItemSlot.Weapon);
        return weapon != null ? (Weapon) weapon : new Fists();
    }
}

package main.equipment.manager;

import main.attributes.StatAttributes;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.items.Item;
import main.equipment.items.ItemSlot;
import main.equipment.items.armor.Armor;
import main.equipment.items.weapon.Weapon;
import main.hero.Hero;
import main.hero.HeroClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HeroEquipmentManager implements EquipmentManager {
    private final Map<ItemSlot, Item> equipped = new HashMap<ItemSlot, Item>();
    private Hero hero;

    @Override
    public void equip(Item item) throws InvalidItemException {
        checkRequirements(item);

        equipped.put(item.slot, item);
    }

    private void checkRequirements(Item item) throws InvalidItemException {
        boolean levelOk = hero.getLevel() >= item.requiredLevel;
        if (!levelOk) {
            throw new InvalidItemException("You do not meet the required level (%d) to equip this item.".formatted(item.requiredLevel));
        }
    }

    @Override
    public StatAttributes getTotalArmorAttributes() {
        return null;
    }

    public void bind(Hero hero) {
        this.hero = hero;
    }
}

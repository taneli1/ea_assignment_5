package main.equipment.manager;

import main.attributes.StatAttributeHolder;
import main.equipment.ItemUser;
import main.equipment.exceptions.InvalidArmorException;
import main.equipment.exceptions.InvalidItemException;
import main.equipment.exceptions.InvalidWeaponException;
import main.equipment.items.Item;
import main.equipment.items.ItemSlot;
import main.equipment.items.armor.Armor;
import main.equipment.items.weapon.Weapon;
import main.equipment.items.weapon.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemUserEquipmentManagerTest {

    ItemUser validItemUser = new ItemUser() {
        @Override
        public int getLevel() {
            return 100;
        }

        @Override
        public boolean isEquipable(Item item) {
            return true;
        }
    };

    ItemUser invalidItemUser = new ItemUser() {
        @Override
        public int getLevel() {
            return 100;
        }

        @Override
        public boolean isEquipable(Item item) {
            return false;
        }
    };

    ItemUserEquipmentManager m;

    @BeforeEach
    void setup() {
        m = new ItemUserEquipmentManager();
    }

    @Test
    void equip_validItem_doesNotThrow() {
        Item item = new Armor("", 0, ItemSlot.BODY, null, null);
        assertDoesNotThrow(() -> {
            m.equip(validItemUser, item);
        });
    }

    @Test
    void equip_invalidWeapon_throwsCorrectException() {
        Item item = new Weapon("", 0, WeaponType.AXE, 0);
        assertThrows(InvalidWeaponException.class, () -> {
            m.equip(invalidItemUser, item);
        });
    }

    @Test
    void equip_invalidArmor_throwsCorrectException() {
        Item item = new Armor("", 0, ItemSlot.BODY, null, null);
        assertThrows(InvalidArmorException.class, () -> {
            m.equip(invalidItemUser, item);
        });
    }


    @Test
    void equip_unEquipableItem_throwsCorrectException() {
        Item item = new Item("", 0, ItemSlot.BODY) {
        };
        assertThrows(InvalidItemException.class, () -> {
            m.equip(invalidItemUser, item);
        });
    }

    @Test
    void getEquippedArmorAttributes_returns_armorAttributes() throws Exception {
        Item item = new Armor("", 0, ItemSlot.BODY, null, new StatAttributeHolder(2, 2, 2));
        m.equip(validItemUser, item);
        assertEquals(2, m.getEquippedArmorAttributes().getStr());
    }

    @Test
    void getEquippedWeapon_returns_equippedWeapon() throws Exception {
        Item item = new Weapon("", 0, WeaponType.AXE, 0);
        m.equip(validItemUser, item);
        assertEquals(item, m.getEquippedWeapon());
    }

    @Test
    void getEquippedWeapon_doesNotReturnNull_whenNoWeaponIsEquipped() {
        assertNotNull(m.getEquippedWeapon());
    }
}
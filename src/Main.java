import main.equipment.items.Item;
import main.equipment.items.armor.ArmorFactory;
import main.equipment.items.weapon.WeaponFactory;
import main.hero.Hero;
import main.hero.HeroClass;
import main.hero.HeroFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        Hero hero = HeroFactory.buildHero("Test", HeroClass.MAGE);
        Item chest = ArmorFactory.testChest();
        Item legs = ArmorFactory.testLegs();
        Item head = ArmorFactory.testHead();
        Item staff = WeaponFactory.testStaff();
        hero.equip(staff);
        System.out.println(hero.display());
    }
}
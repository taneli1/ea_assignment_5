import main.equipment.items.Item;
import main.equipment.items.armor.ArmorFactory;
import main.equipment.items.weapon.WeaponFactory;
import main.hero.Hero;
import main.hero.HeroClass;
import main.hero.HeroFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        Hero hero = HeroFactory.buildHero("Test", HeroClass.MAGE);
        Item chest = ArmorFactory.chest();
        Item legs = ArmorFactory.legs();
        Item head = ArmorFactory.head();
        Item staff = WeaponFactory.staff();
        hero.equip(staff);
        System.out.println(hero.display());
    }
}
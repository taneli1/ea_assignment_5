import main.app.ConsoleApp;
import main.game.controllers.HeroCreationController;
import main.game.controllers.MainGameController;
import main.hero.Hero;
import main.hero.HeroClass;
import main.hero.HeroFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        Hero hero = HeroFactory.buildHero("Mage", HeroClass.MAGE);
        MainGameController ctrl = new MainGameController(hero);
        ConsoleApp app = new ConsoleApp(ctrl);
        app.start();
    }
}
package main.game.events.creation;

import main.game.events.GameAction;
import main.hero.HeroBuilder;
import main.hero.HeroClass;

public class CreationActionFactory {
    public static GameAction classOption(HeroBuilder builder, HeroClass heroClass) {
        return new GameActionSelectClass(builder, heroClass);
    }
}

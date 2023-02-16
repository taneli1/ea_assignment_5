package main.game.events.creation;

import main.game.events.GameAction;
import main.hero.HeroBuilder;
import main.hero.HeroClass;

import java.util.Arrays;
import java.util.List;

public class CreationActionFactory {
    public static List<GameAction> listClassOptions(HeroBuilder builder) {
        return Arrays.stream(HeroClass.values())
                .map((it) -> CreationActionFactory.classOption(builder, it))
                .toList();
    }

    public static GameAction classOption(HeroBuilder builder, HeroClass heroClass) {
        return new GameActionSelectClass(builder, heroClass);
    }
}

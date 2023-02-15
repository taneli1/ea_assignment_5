package main.game.events.creation;

import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.events.GameEventInfo;
import main.hero.HeroBuilder;
import main.hero.HeroClass;

class GameActionSelectClass implements GameAction {
    private final HeroBuilder builder;
    private final HeroClass heroClass;

    GameActionSelectClass(HeroBuilder builder, HeroClass heroClass) {
        this.heroClass = heroClass;
        this.builder = builder;
    }

    @Override
    public GameEvent execute() {
        builder.heroClass(heroClass);
        return new GameEventInfo("Class " + heroClass + " selected.");
    }

    @Override
    public String display() {
        return "Select class: " + heroClass;
    }
}

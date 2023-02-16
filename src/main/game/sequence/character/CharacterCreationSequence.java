package main.game.sequence.character;

import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.events.creation.CreationActionFactory;
import main.game.sequence.GameSequence;
import main.hero.Hero;
import main.hero.HeroBuilder;

import java.util.List;
import java.util.function.Consumer;

public class CharacterCreationSequence implements GameSequence {
    private final HeroBuilder builder = new HeroBuilder();
    private final List<GameAction> userOptions = CreationActionFactory.listClassOptions(builder);
    private final Consumer<Hero> onComplete;

    public CharacterCreationSequence(Consumer<Hero> onComplete) {
        this.onComplete = onComplete;
    }

    @Override
    public GameEvent executeAction(GameAction action) {
        GameEvent event = action.execute();
        onComplete.accept(builder.build());
        return event;
    }

    @Override
    public List<GameAction> getOptions() {
        return userOptions;
    }

    @Override
    public String display() {
        return "Create a character by selecting one of the classes:";
    }
}

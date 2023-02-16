package main.game.sequences.character;

import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.events.GameEventInfo;
import main.game.events.creation.CreationActionFactory;
import main.game.sequences.GameSequence;
import main.game.util.Nothing;
import main.hero.Hero;
import main.hero.HeroBuilder;

import java.util.List;
import java.util.function.Function;


public class CharacterCreationSequence extends GameSequence<Nothing, Hero> {
    private final HeroBuilder builder = new HeroBuilder();
    private final Function<Hero, Void> onComplete;

    public CharacterCreationSequence(Function<Hero, Void> onComplete) {
        this.onComplete = onComplete;
    }

    @Override
    public void beginSequence(Nothing nothing) {
        GameEvent start = new GameEventInfo("Select a class for the character you will be playing:");
        getListeners().forEach((it) -> it.onSequenceEvent(start));

        List<GameAction> classOptions = CreationActionFactory.listClassOptions(builder);
        getListeners().forEach((it) -> it.onSequenceRequestAction(classOptions));
    }


    @Override
    public void queueAction(GameAction action) {
        action.execute();
        GameEvent finished = new GameEventInfo("Class creation finished.");
        getListeners().forEach((it) -> it.onSequenceEvent(finished));
        this.onComplete.apply(builder.build());
    }
}

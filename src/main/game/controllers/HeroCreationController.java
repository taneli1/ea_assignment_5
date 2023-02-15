package main.game.controllers;

import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.events.GameEventInfo;
import main.game.events.creation.CreationActionFactory;
import main.hero.HeroBuilder;
import main.hero.HeroClass;

import java.util.Arrays;
import java.util.List;

/**
 * A controller handling the creation of a character.
 */
public class HeroCreationController extends GameController {
    private final HeroBuilder builder = new HeroBuilder();

    @Override
    public void start() {
        GameEvent start = new GameEventInfo("Select a class for the character you will be playing:");
        notifyListeners(start);

        loop();
    }

    @Override
    public void queuePlayerAction(GameAction gameAction) {
        GameEvent result = gameAction.execute();
        notifyListeners(result);
        loop();
    }

    private void loop() {
        if (!builder.isReady()) {
            List<GameAction> classOptions = Arrays.stream(HeroClass.values())
                    .map((it) -> CreationActionFactory.classOption(builder, it))
                    .toList();
            requestAction(classOptions);
            return;
        }

        GameEvent finished = new GameEventInfo("Class creation finished.");
        notifyListeners(finished);

        // TODO Controller comms?
    }
}

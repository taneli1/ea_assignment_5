package main.game.controllers;

import main.game.events.GameAction;
import main.game.sequence.GameSequence;
import main.game.sequence.GameSequenceProvider;

public class MainGameController extends GameController {
    private final GameSequenceProvider provider = new GameSequenceProvider();

    @Override
    public void start() {
        loop();
    }

    private void loop() {
        GameSequence seq = provider.next();
        notifyGameControllerListeners(seq);
        requestUserAction(seq.getOptions());
    }

    @Override
    public void playerAction(GameAction gameAction) {
        notifyGameControllerListeners(provider.current().executeAction(gameAction));
        loop();
    }
}

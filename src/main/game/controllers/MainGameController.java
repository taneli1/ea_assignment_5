package main.game.controllers;

import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.sequences.GameSeqHandler;
import main.game.sequences.SequenceListener;

import java.util.List;

public class MainGameController extends GameController implements SequenceListener {
    GameSeqHandler h = new GameSeqHandler(this);

    @Override
    public void start() {
        h.start();
    }

    @Override
    public void playerAction(GameAction gameAction) {
        h.userAction(gameAction);
    }

    @Override
    public void onSequenceEvent(GameEvent ev) {
        notifyGameControllerListeners(ev);
    }

    @Override
    public void onSequenceRequestAction(List<GameAction> options) {
        requestUserAction(options);
    }
}

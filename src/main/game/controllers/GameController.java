package main.game.controllers;

import main.game.events.GameEvent;
import main.game.events.GameEventListener;
import main.game.events.GameAction;
import main.game.util.Listenable;

import java.util.List;

public abstract class GameController extends Listenable<GameEventListener> {
    public abstract void start();

    public abstract void playerAction(GameAction gameAction);

    public void notifyGameControllerListeners(GameEvent ev) {
        getListeners().forEach((it) -> {
            it.onGameEvent(ev);
        });
    }

    public void requestUserAction(List<GameAction> options) {
        getListeners().forEach((it) -> {
            it.onUserActionRequested(options);
        });
    }
}

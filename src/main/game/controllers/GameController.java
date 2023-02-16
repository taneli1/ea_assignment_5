package main.game.controllers;

import main.game.events.GameEvent;
import main.game.events.GameEventListener;
import main.game.events.GameAction;
import main.game.util.Listenable;

import java.util.List;

/**
 * Handle the game. All game events and actions are routed through this controller.
 */
public abstract class GameController extends Listenable<GameEventListener> {
    public abstract void start();

    public abstract void playerAction(GameAction gameAction);

    void notifyGameControllerListeners(GameEvent ev) {
        getListeners().forEach((it) -> {
            it.onGameEvent(ev);
        });
    }

    void requestUserAction(List<GameAction> options) {
        getListeners().forEach((it) -> {
            it.onUserActionRequested(options);
        });
    }
}

package main.game.controllers;

import main.game.events.GameEvent;
import main.game.events.GameEventListener;
import main.game.events.GameAction;

import java.util.ArrayList;
import java.util.List;

/**
 * A controller which handles a section or a functionality of the game.
 */
public abstract class GameController {
    private final List<GameEventListener> listeners = new ArrayList<>();

    public abstract void start();

    public abstract void queuePlayerAction(GameAction gameAction);

    public final void registerListener(GameEventListener listener) {
        this.listeners.add(listener);
    }

    // -------------------------- package private --------------------------
    // -------------------------- package private --------------------------

    void notifyListeners(GameEvent ev) {
        listeners.forEach((it) -> {
            it.notify(ev);
        });
    }

    void requestAction(List<GameAction> options) {
        listeners.forEach((it) -> {
            it.requestAction(options);
        });
    }
}

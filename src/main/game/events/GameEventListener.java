package main.game.events;

import java.util.List;

public interface GameEventListener {
    /**
     * Notify the listener about a GameEvent
     */
    void onGameEvent(GameEvent event);

    /**
     * Request an action to be performed by the user, offering a set of options.
     */
    void onUserActionRequested(List<GameAction> options);
}

package main.game.events;

import java.util.List;
import java.util.Set;

public interface GameEventListener {
    /**
     * Notify the listener about a GameEvent
     */
    void notify(GameEvent event);

    /**
     * Request an action to be performed by the user, offering a set of options.
     */
    void requestAction(List<GameAction> options);
}

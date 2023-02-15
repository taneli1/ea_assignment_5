package main.game.events;

/**
 * Action which can be presented to the user, and executed resulting in something.
 */
public interface GameAction extends GameEvent {
    GameEvent execute();
}

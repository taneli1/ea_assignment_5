package main.game.events;


public interface GameEvent {
    /**
     * Information about this event relevant to the player of the game. Could be an option displayed to the user,
     * description of something, or general game information.
     * <p>
     * Every action in the game is implemented as a GameEvent.
     *
     * @return a string describing the event.
     */
    String display();
}

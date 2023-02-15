package main.game.events;

public class GameEventInfo implements GameEvent {
    private final String text;

    public GameEventInfo(String text) {
        this.text = text;
    }

    @Override
    public String display() {
        return text;
    }
}

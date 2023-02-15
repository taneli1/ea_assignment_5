package main.game.events.system;

import main.game.events.GameEvent;

class GameEventRequestPlayerAction implements GameEvent {
    @Override
    public String display() {
        return "What would you like to do?";
    }
}

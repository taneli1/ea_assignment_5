package main.game.events.system;

import main.game.Player;
import main.game.events.GameEvent;

class GameEventStart implements GameEvent {
    private final Player p;

    public GameEventStart(Player p) {
        this.p = p;
    }

    @Override
    public String display() {
        return "The game starts with a great story, which involves the player: " + p.getName()
                + " in the lore. The player starts at a small village with nothing to their name.";
    }
}

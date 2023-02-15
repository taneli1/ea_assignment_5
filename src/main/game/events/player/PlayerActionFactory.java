package main.game.events.player;

import main.game.Player;
import main.game.events.GameAction;

public class PlayerActionFactory {
    public static GameAction doNothing() {
        return new GameActionDoNothing();
    }

    public static GameAction displaySelf(Player p) {
        return new GameActionDisplaySelf(p);
    }
}

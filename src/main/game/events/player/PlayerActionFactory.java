package main.game.events.player;

import main.game.Player;
import main.game.controllers.GameController;
import main.game.events.GameAction;
import main.game.events.GameEventListener;

public class PlayerActionFactory {
    public static GameAction doNothing() {
        return new GameActionDoNothing();
    }

    public static GameAction displaySelf(Player p) {
        return new GameActionDisplaySelf(p);
    }

}

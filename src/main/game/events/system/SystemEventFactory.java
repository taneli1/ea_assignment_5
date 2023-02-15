package main.game.events.system;

import main.game.Player;
import main.game.events.GameEvent;

public class SystemEventFactory {
    public static GameEvent gameStart(Player player) {
        return new GameEventStart(player);
    }

    public static GameEvent requestAction() {
        return new GameEventRequestPlayerAction();
    }
}

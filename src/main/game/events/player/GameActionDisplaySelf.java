package main.game.events.player;

import main.game.Player;
import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.events.GameEventInfo;

class GameActionDisplaySelf implements GameAction {
    private final Player p;

    GameActionDisplaySelf(Player p) {
        this.p = p;
    }

    @Override
    public GameEvent execute() {
        return new GameEventInfo(p.display());
    }

    @Override
    public String display() {
        return "See character information.";
    }
}

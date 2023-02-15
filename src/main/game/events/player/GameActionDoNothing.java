package main.game.events.player;

import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.events.GameEventInfo;

class GameActionDoNothing implements GameAction {
    @Override
    public GameEvent execute() {
        return new GameEventInfo("You did absolutely nothing!");
    }

    @Override
    public String display() {
        return "Do nothing.";
    }
}

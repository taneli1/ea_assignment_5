package main.game.sequence;

import main.game.events.GameAction;
import main.game.events.GameEvent;

import java.util.List;

public interface GameSequence extends GameEvent {
    List<GameAction> getOptions();

    GameEvent executeAction(GameAction action);
}

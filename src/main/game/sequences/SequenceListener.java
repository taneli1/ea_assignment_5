package main.game.sequences;

import main.game.events.GameAction;
import main.game.events.GameEvent;

import java.util.List;

public interface SequenceListener {
    void onSequenceEvent(GameEvent ev);

    void onSequenceRequestAction(List<GameAction> options);

}

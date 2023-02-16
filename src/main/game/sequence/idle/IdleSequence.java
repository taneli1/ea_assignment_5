package main.game.sequence.idle;

import main.game.Player;
import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.events.player.PlayerActionFactory;
import main.game.sequence.GameSequence;

import java.util.List;

public class IdleSequence implements GameSequence {
    private final List<GameAction> options;

    public IdleSequence(Player player) {
        this.options = List.of(PlayerActionFactory.doNothing(), PlayerActionFactory.displaySelf(player));
    }

    @Override
    public List<GameAction> getOptions() {
        return options;
    }

    @Override
    public GameEvent executeAction(GameAction action) {
        return action.execute();
    }

    @Override
    public String display() {
        return "What would you like to do?";
    }
}

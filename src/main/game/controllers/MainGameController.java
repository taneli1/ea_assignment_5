package main.game.controllers;

import main.game.Player;
import main.game.events.GameEvent;
import main.game.events.GameAction;
import main.game.events.player.PlayerActionFactory;
import main.game.events.system.SystemEventFactory;

import java.util.List;

/**
 * Controller responsible for the main game loop.
 */
public class MainGameController extends GameController {
    private final Player player;

    public MainGameController(Player player) {
        this.player = player;
    }

    @Override
    public void start() {
        GameEvent start = SystemEventFactory.gameStart(player);
        notifyListeners(start);

        gameLoop();
    }

    private void gameLoop() {
        List<GameAction> gameActions = List.of(PlayerActionFactory.doNothing(), PlayerActionFactory.displaySelf(this.player));
        GameEvent reqAction = SystemEventFactory.requestAction();
        notifyListeners(reqAction);
        requestAction(gameActions);
    }

    @Override
    public void queuePlayerAction(GameAction gameAction) {
        GameEvent result = gameAction.execute();
        notifyListeners(result);
        gameLoop();
    }
}

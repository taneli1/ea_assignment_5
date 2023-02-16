package main.app;

import main.game.controllers.GameController;
import main.game.events.GameEvent;
import main.game.events.GameEventListener;
import main.game.events.GameAction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleApp implements GameEventListener {
    private final GameController controller;

    public ConsoleApp(GameController controller) {
        this.controller = controller;
        this.controller.registerListener(this);
    }

    public void start() {
        this.controller.start();
    }

    @Override
    public void onGameEvent(GameEvent event) {
        System.out.println();
        System.out.println(event.display());
    }

    @Override
    public void onUserActionRequested(List<GameAction> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ") " + options.get(i).display());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            int index = Integer.parseInt(input.trim()) - 1;
            controller.playerAction(options.get(index));
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}

package main.game.sequences;

import main.game.controllers.GameController;
import main.game.events.GameAction;
import main.game.events.GameEvent;
import main.game.sequences.character.CharacterCreationSequence;
import main.game.util.Nothing;

import java.util.List;

public class GameSeqHandler implements SequenceListener {
    GameController controller;
    CharacterCreationSequence seq = new CharacterCreationSequence((result) -> {
        System.out.println("Result " + result);
        return null;
    });

    public GameSeqHandler(GameController c) {
        this.controller = c;
    }

    public void start() {
        seq.registerListener(this);
        seq.beginSequence(new Nothing());
    }

    @Override
    public void onSequenceEvent(GameEvent ev) {
        controller.notifyGameControllerListeners(ev);
    }

    @Override
    public void onSequenceRequestAction(List<GameAction> options) {
        controller.requestUserAction(options);
    }

    public void userAction(GameAction action) {
        seq.queueAction(action);
    }
}

package main.game.sequences;

import main.game.events.GameAction;
import main.game.util.Listenable;

/**
 * Contains a specific sequence/section for the game. Takes Input as a parameter on begin,
 * and notifies the listeners with Result object when sequence is finished.
 * <p>
 * Could for example be a combat sequence.
 */
public abstract class GameSequence<Input, Result> extends Listenable<SequenceListener> {
    protected abstract void beginSequence(Input input);

    /**
     * Give an action to the sequence.
     */
    protected abstract void queueAction(GameAction action);

    protected GameSequence<?, ?> chain(GameSequence<?, ?> next) {
        getListeners().forEach(next::registerListener);
        return next;
    }
}

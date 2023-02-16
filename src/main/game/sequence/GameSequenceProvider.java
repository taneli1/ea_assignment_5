package main.game.sequence;

import main.game.sequence.character.CharacterCreationSequence;
import main.game.sequence.idle.IdleSequence;
import main.hero.Hero;

public class GameSequenceProvider {
    private GameSequence currentSequence;
    private Hero hero;

    public GameSequence current() {
        return currentSequence;
    }

    public GameSequence next() {
        currentSequence = decideNextSequence();
        return currentSequence;
    }

    private GameSequence decideNextSequence() {
        if (hero == null) {
            return new CharacterCreationSequence(hero -> {
                this.hero = hero;
            });
        }

        return new IdleSequence(hero);
    }
}

package main.attributes.hero;


import main.attributes.StatAttributes;
import main.hero.Hero;

/**
 * Base class for stat attributes of different hero classes.
 */
abstract class HeroClassAttributes implements StatAttributes {
    private final int baseStr;
    private final int baseDex;
    private final int baseInt;
    private final int perLevelStr;
    private final int perLevelDex;
    private final int perLevelInt;
    private final int levelMultiplier;

    public HeroClassAttributes(int level, int baseStr, int baseDex, int baseInt, int perLevelStr, int perLevelDex, int perLevelInt) {
        // Level 1, level multiplier == 0
        this.levelMultiplier = level - 1;
        this.baseStr = baseStr;
        this.baseDex = baseDex;
        this.baseInt = baseInt;
        this.perLevelStr = perLevelStr;
        this.perLevelDex = perLevelDex;
        this.perLevelInt = perLevelInt;
    }

    @Override
    public final int getStr() {
        return baseStr + (perLevelStr * levelMultiplier);
    }

    @Override
    public final int getDex() {
        return baseDex + (perLevelDex * levelMultiplier);
    }

    @Override
    public final int getInt() {
        return baseInt + (perLevelInt * levelMultiplier);
    }
}

class MageAttributes extends HeroClassAttributes {
    public MageAttributes(int level) {
        super(level, 1, 1, 8, 1, 1, 5);
    }
}

class RangerAttributes extends HeroClassAttributes {
    public RangerAttributes(int level) {
        super(level, 1, 7, 1, 1, 5, 1);
    }
}

class RogueAttributes extends HeroClassAttributes {
    public RogueAttributes(int level) {
        super(level, 2, 6, 1, 1, 4, 1);
    }
}

class WarriorAttributes extends HeroClassAttributes {
    public WarriorAttributes(int level) {
        super(level, 5, 2, 1, 3, 2, 1);
    }
}
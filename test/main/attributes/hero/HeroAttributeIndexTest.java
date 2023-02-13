package main.attributes.hero;

import main.attributes.StatAttributes;
import main.hero.HeroClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeIndexTest {
    HeroAttributeIndex index = new HeroAttributeIndex();

    @Test
    void resolveLevelAttributes_mage() {
        StatAttributes ex = new MageAttributes(10);
        StatAttributes act = index.resolveLevelAttributes(HeroClass.MAGE, 10);
        assertEquals(ex.getInt(), act.getInt());
        assertEquals(ex.getDex(), act.getDex());
        assertEquals(ex.getStr(), act.getStr());
    }

    @Test
    void resolveLevelAttributes_ranger() {
        StatAttributes ex = new RangerAttributes(10);
        StatAttributes act = index.resolveLevelAttributes(HeroClass.RANGER, 10);
        assertEquals(ex.getInt(), act.getInt());
        assertEquals(ex.getDex(), act.getDex());
        assertEquals(ex.getStr(), act.getStr());
    }

    @Test
    void resolveLevelAttributes_rogue() {
        StatAttributes ex = new RogueAttributes(10);
        StatAttributes act = index.resolveLevelAttributes(HeroClass.ROGUE, 10);
        assertEquals(ex.getInt(), act.getInt());
        assertEquals(ex.getDex(), act.getDex());
        assertEquals(ex.getStr(), act.getStr());
    }

    @Test
    void resolveLevelAttributes_warrior() {
        StatAttributes ex = new WarriorAttributes(10);
        StatAttributes act = index.resolveLevelAttributes(HeroClass.WARRIOR, 10);
        assertEquals(ex.getInt(), act.getInt());
        assertEquals(ex.getDex(), act.getDex());
        assertEquals(ex.getStr(), act.getStr());
    }
}
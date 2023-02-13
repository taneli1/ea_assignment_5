package main.attributes.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroClassAttributesTest {

    @Test
    void attributes_doNotScale_atLevelOne() {
        HeroClassAttributes att = new HeroClassAttributes(1, 2, 3, 4, 100, 100, 100) {
        };
        assertEquals(2, att.getStr());
        assertEquals(3, att.getDex());
        assertEquals(4, att.getInt());
    }

    @Test
    void attributes_scale_withLevel() {
        HeroClassAttributes att = new HeroClassAttributes(6, 1, 1, 1, 10, 20, 30) {
        };
        assertEquals(51, att.getStr());
        assertEquals(101, att.getDex());
        assertEquals(151, att.getInt());
    }

    @Test
    void heroClass_mage_atLevelOne() {
        HeroClassAttributes att = new MageAttributes(1);
        assertEquals(1, att.getStr());
        assertEquals(1, att.getDex());
        assertEquals(8, att.getInt());
    }

    @Test
    void heroClass_ranger_atLevelOne() {
        HeroClassAttributes att = new RangerAttributes(1);
        assertEquals(1, att.getStr());
        assertEquals(7, att.getDex());
        assertEquals(1, att.getInt());
    }

    @Test
    void heroClass_rogue_atLevelOne() {
        HeroClassAttributes att = new RogueAttributes(1);
        assertEquals(2, att.getStr());
        assertEquals(6, att.getDex());
        assertEquals(1, att.getInt());
    }

    @Test
    void heroClass_warrior_atLevelOne() {
        HeroClassAttributes att = new WarriorAttributes(1);
        assertEquals(5, att.getStr());
        assertEquals(2, att.getDex());
        assertEquals(1, att.getInt());
    }

    @Test
    void heroClass_mage_atLevelTwo() {
        HeroClassAttributes att = new MageAttributes(2);
        assertEquals(2, att.getStr());
        assertEquals(2, att.getDex());
        assertEquals(13, att.getInt());
    }

    @Test
    void heroClass_ranger_atLevelTwo() {
        HeroClassAttributes att = new RangerAttributes(2);
        assertEquals(2, att.getStr());
        assertEquals(12, att.getDex());
        assertEquals(2, att.getInt());
    }

    @Test
    void heroClass_rogue_atLevelTwo() {
        HeroClassAttributes att = new RogueAttributes(2);
        assertEquals(3, att.getStr());
        assertEquals(10, att.getDex());
        assertEquals(2, att.getInt());
    }

    @Test
    void heroClass_warrior_atLevelTwo() {
        HeroClassAttributes att = new WarriorAttributes(2);
        assertEquals(8, att.getStr());
        assertEquals(4, att.getDex());
        assertEquals(2, att.getInt());
    }
}
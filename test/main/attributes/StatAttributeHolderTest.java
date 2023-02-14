package main.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatAttributeHolderTest {

    @Test
    void constructor_withOutParameters_returnsZeroes() {
        StatAttributeHolder att = new StatAttributeHolder();
        assertEquals(0, att.getStr());
        assertEquals(0, att.getDex());
        assertEquals(0, att.getInt());
    }

    @Test
    void methods_returns_correctValues() {
        StatAttributeHolder att = new StatAttributeHolder(1, 2, 3);
        assertEquals(1, att.getStr());
        assertEquals(2, att.getDex());
        assertEquals(3, att.getInt());
    }
}
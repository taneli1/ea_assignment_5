package main.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatAttributesTest {

    @Test
    void combine_defaultImplementation_worksAsExpected() {
        StatAttributes att1 = new StatAttributes() {
            @Override
            public int getStr() {
                return 1;
            }

            @Override
            public int getDex() {
                return 2;
            }

            @Override
            public int getInt() {
                return 3;
            }
        };

        StatAttributes att2 = new StatAttributes() {
            @Override
            public int getStr() {
                return 3;
            }

            @Override
            public int getDex() {
                return 2;
            }

            @Override
            public int getInt() {
                return 1;
            }
        };

        StatAttributes combined = att1.combine(att2);

        assertEquals(4, combined.getStr());
        assertEquals(4, combined.getDex());
        assertEquals(4, combined.getInt());
    }
}
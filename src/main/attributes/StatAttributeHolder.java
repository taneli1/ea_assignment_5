package main.attributes;

/**
 * Simple implementation for StatAttributes.
 */
public class StatAttributeHolder implements StatAttributes {
    private final int str;
    private final int dex;
    private final int intel;

    public StatAttributeHolder(int str, int dex, int intel) {
        this.str = str;
        this.dex = dex;
        this.intel = intel;
    }

    @Override
    public int getStr() {
        return str;
    }

    @Override
    public int getDex() {
        return dex;
    }

    @Override
    public int getInt() {
        return intel;
    }
}

package main.attributes;

/**
 * Common implementation for StatAttributes (eg. used for Armor).
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

    /**
     * Instance with all values set to 0.
     */
    public StatAttributeHolder() {
        this.str = 0;
        this.dex = 0;
        this.intel = 0;
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

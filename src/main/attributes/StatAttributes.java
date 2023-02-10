package main.attributes;


public interface StatAttributes {
    int getStr();

    int getDex();

    int getInt();

    /**
     * Combine the values of two StatAttributes.
     *
     * @return new StatAttribute instance.
     */
    default StatAttributes combine(StatAttributes attr) {
        return new StatAttributeHolder(
                this.getStr() + attr.getStr(),
                this.getDex() + attr.getDex(),
                this.getInt() + attr.getInt()
        );
    }

    default String print() {
        return "Str: " + getStr() + "\n" +
                "Dex: " + getDex() + "\n" +
                "Int: " + getInt() + "\n";
    }
}

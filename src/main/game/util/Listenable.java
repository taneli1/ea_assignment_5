package main.game.util;

import java.util.ArrayList;
import java.util.List;

public abstract class Listenable<T> {
    private final List<T> listeners = new ArrayList<>();

    public final void registerListener(T listener) {
        this.listeners.add(listener);
    }

    public final List<T> getListeners() {
        return this.listeners;
    }
}

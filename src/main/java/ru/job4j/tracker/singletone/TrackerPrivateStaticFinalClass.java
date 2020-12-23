package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Tracker;

public class TrackerPrivateStaticFinalClass {
    private TrackerPrivateStaticFinalClass() {
    }

    public static Tracker getInstance() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final Tracker instance = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerPrivateStaticFinalClass.getInstance();
    }
}
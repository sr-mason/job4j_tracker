package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Tracker;

public enum TrackerEnum {
    INSTANCE;
    private final Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerEnum.INSTANCE.getTracker();
    }
}
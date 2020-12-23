package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerStaticField {
    private static Tracker instance;

    private TrackerStaticField() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return instance.add(item);
    }

    public static void main(String[] args) {
        Tracker trackerStaticField = TrackerStaticField.getInstance();
    }
}
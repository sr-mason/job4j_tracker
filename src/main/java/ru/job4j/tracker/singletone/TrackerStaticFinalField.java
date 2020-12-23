package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.Item;
public class TrackerStaticFinalField {
    private static final Tracker instance = new Tracker();

    private TrackerStaticFinalField() {
    }

    public static Tracker getInstance(){
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerStaticFinalField.getInstance();
    }
}
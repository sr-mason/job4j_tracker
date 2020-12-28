package ru.job4j.tracker.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add(0, "Petr");
        name.add(1, "Ivan");
        name.add(2, "Stepan");
        for (Object value : name) {
            System.out.println(value);
        }
    }
}

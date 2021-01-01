package ru.job4j.tracker.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] mas : list) {
            for (Integer num : mas) {
                rsl.add(num);
            }
        }
        return rsl;
    }
}

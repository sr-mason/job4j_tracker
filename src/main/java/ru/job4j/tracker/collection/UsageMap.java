package ru.job4j.tracker.collection;

import java.util.HashMap;
public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanovIvan@mail.ru", "Ivanov Ivan Ivanovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

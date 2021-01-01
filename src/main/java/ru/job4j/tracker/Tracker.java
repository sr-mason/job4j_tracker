package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        List<Item> a = new ArrayList<>();
        for (Item item : items) {
            if (item != null) {
                a.add(item);
            }
        }
        return a;
    }

    public List<Item> findByName(String key) {
        List<Item> a = new ArrayList<>();
        for (Item item : items) {
            if (item.getName() != null && item.getName().equals(key)) {
                a.add(item);
            }
        }
        return a;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        for (Item i : items) {
            if (i.getId() == id) {
                items.set(items.indexOf(i), item);
                item.setId(id);
                result = true;
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean flag = index != -1;
        if (flag) {
            items.remove(index);
        }
        return flag;
    }
}
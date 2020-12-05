package ru.job4j.tracker;
import java.util.Arrays;
public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] a = new Item[size];
        int countA = 0;
        for (Item item : items) {
            if (item != null) {
                a[countA++] = item;
            }
        }
        return Arrays.copyOf(a, countA);
    }

    public Item[] findByName(String key) {
        Item[] a = new Item[size];
        int countA = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                a[countA++] = item;
            }
        }
        return Arrays.copyOf(a, countA);
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean flag = index != -1;
        if (flag) {
            item.setId(id);
            items[index] = item;
        }
        return flag;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
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
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
        }
        return flag;
    }
}
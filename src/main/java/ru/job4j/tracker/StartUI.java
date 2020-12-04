package ru.job4j.tracker;
import java.time.format.DateTimeFormatter;
public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.setId(1);
        item.setName("Test");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.getCreated().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
        Tracker tracker = new Tracker();
        tracker.add(item);
        System.out.println(tracker.findById(item.getId()));
        Item item1 = new Item();
        item1.setId(2);
        item1.setName("Test2");
        System.out.println(item1);
    }
}

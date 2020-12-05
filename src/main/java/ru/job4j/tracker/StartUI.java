package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0 -> {
                    System.out.println("=== Create a new Item ====");
                    System.out.print("id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(id, name);
                    tracker.add(item);
                }
                case 1 -> {
                    System.out.println("=== Show all items ====");
                    Item[] items = tracker.findAll();
                    for (Item itm: items) {
                        System.out.println(itm.toString());
                    }
                }
                case 2 -> {
                    System.out.println("=== Edit item ====");
                    System.out.println("Enter change id item: ");
                    int idChange = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter name item change: ");
                    String nameChange = scanner.nextLine();
                    Item item1 = new Item(idChange, nameChange);
                    if (tracker.replace(idChange, item1)) {
                        System.out.println("Change completed");
                    } else {
                        System.out.println("Change error");
                    }
                }
                case 3 -> {
                    System.out.println("=== Delete item ====");
                    System.out.println("Enter delete id item: ");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(idDelete)) {
                        System.out.println("Delete completed");
                    } else {
                        System.out.println("Delete error");
                    }
                }
                case 4 -> {
                    System.out.println("=== Find item by Id. ===");
                    System.out.println("Enter id find item: ");
                    int idFind = Integer.parseInt(scanner.nextLine());
                    System.out.println(tracker.findById(idFind));
                }
                case 5 -> {
                    System.out.println("=== Find items by name ===");
                    System.out.println("Enter name find item: ");
                    String nameFind = scanner.nextLine();
                    System.out.println(Arrays.toString(tracker.findByName(nameFind)));
                    run = true;
                }
                case 6 -> run = false;
                default -> System.out.print("Select number on 0 to 6");

            }
        }
    }

    private void showMenu() {
        System.out.printf("%n Menu."
                +  "%n 0. Add new Item"
                + "%n 1. Show all items"
                + "%n 2. Edit item"
                + "%n 2. Edit item"
                + "%n 3. Delete item"
                + "%n 4. Find item by Id"
                + "%n 5. Find items by name"
                + "%n 6. Exit Program %n"
        );
    }

    public static void main(String[] args) {
        /*Item item = new Item();
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
        System.out.println(item1);*/
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

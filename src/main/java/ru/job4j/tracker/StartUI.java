package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item itm: items) {
            System.out.println(itm);
        }
    }
    public static void edit(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int idChange = Integer.parseInt(input.askStr("Enter change id item: "));
        String nameChange = input.askStr("Enter name item change: ");
        Item item1 = new Item(idChange, nameChange);
        if (tracker.replace(idChange, item1)) {
            System.out.println("Change completed");
        } else {
            System.out.println("Change error");
        }
    }

    public static void delete(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int idDelete = Integer.parseInt(input.askStr("Enter delete id item: "));
        if (tracker.delete(idDelete)) {
            System.out.println("Delete completed");
        } else {
            System.out.println("Delete error");
        }
    }
    public static void findId(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id. ===");
        int idFind = Integer.parseInt(input.askStr("Enter id find item: "));

        Item Find = tracker.findById(idFind);
        if (Find != null) {
            System.out.println(Find);
        } else {
            System.out.println("item null, try again");
        }
    }
    public static void findName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String nameFind = input.askStr("Enter name find item: ");
        Item[] item = tracker.findByName(nameFind);
        if (item.length > 0) {
            for (Item value : item) {
                System.out.println(value.getId() + "  " + value.getName());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            switch (select) {
                case 0 -> StartUI.createItem(input, tracker);
                case 1 -> StartUI.showAll(tracker);
                case 2 -> StartUI.edit(input, tracker);
                case 3 -> StartUI.delete(input, tracker);
                case 4 -> StartUI.findId(input, tracker);
                case 5 -> StartUI.findName(input, tracker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

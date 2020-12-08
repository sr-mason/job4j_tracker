package ru.job4j.tracker;

public class FindNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameFind = input.askStr("Enter name find item: ");
        Item[] item = tracker.findByName(nameFind);
        if (item.length > 0) {
            for (Item value : item) {
                System.out.println(value.getId() + "  " + value.getName());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

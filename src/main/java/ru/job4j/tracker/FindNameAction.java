package ru.job4j.tracker;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

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
                out.println(value);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

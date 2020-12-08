package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idChange = Integer.parseInt(input.askStr("Enter change id item: "));
        String nameChange = input.askStr("Enter name item change: ");
        Item item1 = new Item(idChange, nameChange);
        if (tracker.replace(idChange, item1)) {
            System.out.println("Change completed");
        } else {
            System.out.println("Change error");
        }
        return true;
    }
}

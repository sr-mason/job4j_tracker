package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

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
            out.println("Change completed");
        } else {
            out.println("Change error");
        }
        return true;
    }
}

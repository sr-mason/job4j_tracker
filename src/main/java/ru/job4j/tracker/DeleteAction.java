package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idDelete = Integer.parseInt(input.askStr("Enter delete id item: "));
        if (tracker.delete(idDelete)) {
            System.out.println("Delete completed");
        } else {
            System.out.println("Delete error");
        }
        return true;
    }
}

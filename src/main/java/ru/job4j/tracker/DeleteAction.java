package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idDelete = Integer.parseInt(input.askStr("Enter delete id item: "));
        if (tracker.delete(idDelete)) {
            out.println("Delete completed");
        } else {
            out.println("Delete error");
        }
        return true;
    }
}

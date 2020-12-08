package ru.job4j.tracker;

import java.util.Objects;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id. ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idFind = Integer.parseInt(input.askStr("Enter id find item: "));

        Item Find = tracker.findById(idFind);
        out.println(Objects.requireNonNullElse(Find, "item null, try again"));
        return true;
    }
}

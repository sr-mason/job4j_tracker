package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id. ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idFind = Integer.parseInt(input.askStr("Enter id find item: "));

        Item Find = tracker.findById(idFind);
        if (Find != null) {
            System.out.println(Find);
        } else {
            System.out.println("item null, try again");
        }
        return true;
    }
}

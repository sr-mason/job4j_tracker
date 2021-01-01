package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;

public class StartUITest {

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. === Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        CreateAction actions = new CreateAction(output);
        actions.execute(in, tracker);
        assertThat(output.toString(), is("=== Create a new Item ====" + System.lineSeparator() ));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), replacedName, "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenShowAllAction() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1"});
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Show all items ====" + System.lineSeparator() +
                        "1. === Exit ====" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Show all items ====" + System.lineSeparator() +
                        "1. === Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getName()), "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find items by name ===" + System.lineSeparator() +
                        "1. === Exit ====" + System.lineSeparator() +
                        "Item{id=1, name='item'}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find items by name ===" + System.lineSeparator() +
                        "1. === Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "1", "1"});
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("New item");
        tracker.add(item);
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by Id. ===" + System.lineSeparator() +
                        "1. === Exit ====" + System.lineSeparator() +
                        "Item{id=1, name='New item'}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find item by Id. ===" + System.lineSeparator() +
                        "1. === Exit ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1", "0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit ====%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit ====%n"
                )
        ));
    }
}
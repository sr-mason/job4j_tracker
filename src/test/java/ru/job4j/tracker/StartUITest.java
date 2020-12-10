package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. === Exit ====" + System.lineSeparator()));
    }

    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator() ));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), replacedName, "1"});
        UserAction[] actions = {new EditAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find by Id item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new ShowAllAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(new Item[] {item}));
    }

    @Test
    public void findNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("item"));
        Input in = new StubInput(new String[] {"item"});
        FindNameAction actions = new FindNameAction(output);
        actions.execute(in, tracker);
        assertThat(output.toString(), is("Item{id=1, name='item'}" + System.lineSeparator()));
    }

    @Test
    public void findNoNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("item"));
        Input in = new StubInput(new String[] {"i"});
        FindNameAction actions = new FindNameAction(output);
        actions.execute(in, tracker);
        assertThat(output.toString(), is("Заявки с таким именем не найдены" + System.lineSeparator()));
    }

    @Test
        public void whenFindIdAction() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        tracker.add(new Item("Find 1s item by id"));
        tracker.add(new Item("Find 2d item by id"));
        Input in = new StubInput(new String[] {"2"});
        FindIdAction find = new FindIdAction(output);
        find.execute(in, tracker);
        assertThat(output.toString(), is("Item{id=2, name='Find 2d item by id'}" + System.lineSeparator()));
    }

    @Test
    public void whenNoFindIdAction() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        tracker.add(new Item("Find 1s item by id"));
        tracker.add(new Item("Find 2d item by id"));
        Input in = new StubInput(new String[] {"3"});
        FindIdAction find = new FindIdAction(output);
        find.execute(in, tracker);
        assertThat(output.toString(), is("item null, try again" + System.lineSeparator()));
    }
}
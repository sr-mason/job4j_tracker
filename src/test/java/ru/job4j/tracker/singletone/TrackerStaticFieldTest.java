package ru.job4j.tracker.singletone;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import static org.junit.Assert.*;

public class TrackerStaticFieldTest {
    @Test
    public void whenNewTwoClassesThenCreatedOnlyOne() {
        Tracker tracker1 = TrackerStaticField.getInstance();
        Tracker tracker2 = TrackerStaticField.getInstance();
        assertEquals(tracker1, tracker2);
    }
}
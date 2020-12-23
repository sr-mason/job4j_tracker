package ru.job4j.tracker.singletone;


import org.junit.Test;
import ru.job4j.tracker.Tracker;
import static org.junit.Assert.*;

public class TrackerStaticFinalFieldTest {
    @Test
    public void whenNewTwoClassesThenCreatedOnlyOne() {
        Tracker tracker1 = TrackerStaticFinalField.getInstance();
        Tracker tracker2 = TrackerStaticFinalField.getInstance();
        assertEquals(tracker1, tracker2);
    }
}
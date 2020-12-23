package ru.job4j.tracker.singletone;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import static org.junit.Assert.*;

public class TrackerEnumTest {
    @Test
    public void whenNewTwoClassesThenCreatedOnlyOne() {
        Tracker tracker1 = TrackerEnum.INSTANCE.getTracker();
        Tracker tracker2 = TrackerEnum.INSTANCE.getTracker();
        assertEquals(tracker1, tracker2);
    }
}
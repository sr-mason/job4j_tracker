package ru.job4j.tracker.singletone;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import static org.junit.Assert.*;

public class TrackerPrivateStaticFinalClassTest {
    @Test
    public void whenNewTwoClassesThenCreatedOnlyOne() {
        Tracker tracker1 = TrackerPrivateStaticFinalClass.getInstance();
        Tracker tracker2 = TrackerPrivateStaticFinalClass.getInstance();
        assertEquals(tracker1, tracker2);
    }
}
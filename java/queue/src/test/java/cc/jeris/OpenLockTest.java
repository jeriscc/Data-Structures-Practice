package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for my Open Lock Problem.
 */
public class OpenLockTest {

    @Test
    public void testOne() {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        assertTrue("OpenLock ONE should work for basic test", OpenLock.openLock(deadends, "0202") == 6);
    }

    @Test
    public void testTwo() {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        OpenLockTwo ol = new OpenLockTwo();
        assertTrue("OpenLock TWO should work for basic test", ol.openLock(deadends, "0202") == 6);
    }

    @Test
    public void testThree() {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        OpenLockThree ol = new OpenLockThree();
        assertTrue("OpenLock THREE should work for basic test", ol.openLock(deadends, "0202") == 6);
    }
}

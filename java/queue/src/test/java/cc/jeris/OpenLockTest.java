package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for my Circular Queue.
 */
public class OpenLockTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testOne() {
        // Testing my Circular Queue
        String[] deadends = {"0201","0101","0102","1212","2002"};
        assertTrue(OpenLock.openLock(deadends, "0202") == 6);
    }

    @Test
    public void testTWo() {
        // Testing my Circular Queue
        String[] deadends = {"0201","0101","0102","1212","2002"};
        OpenLockThree ol = new OpenLockThree();
        assertTrue(ol.openLock(deadends, "0202") == 6);
    }
}

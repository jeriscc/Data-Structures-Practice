package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for my Circular Queue.
 */
public class BFSTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testOne() {
        Node begin = new Node(1);
        begin.addAdjNode(new Node(3));
        begin.addAdjNode(new Node(4));
        Node end = new Node(2);
        assertTrue("Search should not find unconnectd nodes", BFS.search(begin, end) == -1);
    }
}

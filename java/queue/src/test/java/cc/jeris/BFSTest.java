package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for my BFS implementation.
 */
public class BFSTest {

    @Test
    public void testOne() {
        Node begin = new Node(1);
        begin.addAdjNode(new Node(3));
        begin.addAdjNode(new Node(4));
        Node end = new Node(2);
        assertTrue("Search should not find unconnectd nodes", BFS.search(begin, end) == -1);
    }
}

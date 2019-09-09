package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test suite for DFS implementation.
 */
public class DFSTest {

    @Test
    public void testOne() {
        Node begin = new Node(1);
        begin.addAdjNode(new Node(3));
        begin.addAdjNode(new Node(4));
        Node end = new Node(2);

        DFS dfs = new DFS();
        assertFalse("Search should not find unconnectd nodes", dfs.search(begin, end));
    }
}

package cc.jeris;

import java.util.HashSet;

/**
 * DFS. Note: system's stack should always be considered in space complexity.
 */
public class DFS {
    HashSet<Node> visited = new HashSet<Node>();

    public boolean search(Node start, Node dest) {
        if (start == dest) {
            return true;
        }
        for (Node n : start.neighbors) {
            if (!visited.contains(n)) {
                visited.add(n);
                if (search(n, dest)) {
                    return true;
                }
            }
        }
        return false;
    }
}
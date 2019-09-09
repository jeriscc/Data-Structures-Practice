package cc.jeris;

import java.util.HashSet;

/**
 * DFS
 */
public class DFS {
    HashSet<Node> visited = new HashSet<Node>();

    public boolean search(Node start, Node dest) {
        if (start == dest) {
            return true;
        }
        for (Node n : start.getAdjNodes()) {
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
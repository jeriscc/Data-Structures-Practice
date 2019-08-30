package cc.jeris;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
public class BFS {
    /**
     * Uses Breadth First Search to traverse a graph and find target
     * @param root the root node of the graph to traverse
     * @param target the target node
     */
    public static int search(Node root, Node target) {
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> visitedNodes = new HashSet<>();
        int step = 0;
        // Initialize
        queue.offer(root);
        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node top = queue.poll();
                if (top == target) {
                    return step;
                }
                visitedNodes.add(top);
                ArrayList<Node> neighbors = top.getAdjNodes();
                neighbors.forEach((n) -> {
                    if (!visitedNodes.contains(top)) {
                        queue.offer(n);
                    }
                });
            }
        }
        return -1;
    }
}
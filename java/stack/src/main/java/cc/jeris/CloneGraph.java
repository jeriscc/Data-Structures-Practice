package cc.jeris;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CloneGraph
 *
 * Speed: 100%
 * 
 * The testing and validation is hard to reproduce locally so we will not write
 * a test suite for this solution.
 * 
 * Problem Src: https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    HashMap<Integer, Node> visited = new HashMap<>();

    public Node clone(Node node) {
        if (visited.containsKey(node.data))
            return visited.get(node.data);

        Node newNode = new Node(node.data, new ArrayList<Node>());
        visited.put(node.data, newNode);
        for (Node n : node.neighbors) {
            newNode.neighbors.add(clone(n));
        }
        return newNode;
    }
}
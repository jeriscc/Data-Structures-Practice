package cc.jeris;

import java.util.ArrayList;

/**
 * Node
 */
public class Node {

    public int data;
    public ArrayList<Node> neighbors;

    public Node(int _data) {
        data = _data;
        neighbors = new ArrayList<>();
    }

    public Node(int _data, ArrayList<Node> _neighbors) {
        data = _data;
        neighbors = _neighbors;
    }

    public void addAdjNode(Node n){
        neighbors.add(n);
    }
}
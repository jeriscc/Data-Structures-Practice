package cc.jeris;

import java.util.ArrayList;

/**
 * Node
 */
public class Node {

    private int data;
    private ArrayList<Node> neighbors;

    public Node(int k) {
        data = k;
        neighbors = new ArrayList<Node>();
    }

    /* Getter and setter for data field */
    public int getData() {
        return data;
    }
    public void setData(int k) {
        data = k;
    }

    /* Getter and setter for next field */
    public ArrayList<Node> getAdjNodes() {
        return neighbors;
    }
    public void addAdjNode(Node n){
        neighbors.add(n);
    }
}
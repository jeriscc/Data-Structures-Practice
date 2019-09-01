package cc.jeris;

import java.util.EmptyStackException;

/**
 * Third iteration. Uses a linkedlist data implementation, each node keeps track
 * of the min value.
 * 
 * Advantages: no empty slots (which the array implementation had). No need for
 * extra stack to keep track of mins.
 * 
 * While there have been code complexity gains, there seems to have been no perf
 * gains in the submission.
 */
public class MinStackThree {

    private class Node {
        public Node next;
        public int min;
        public int data;

        public Node(int d, int m) {
            data = d;
            min = m;
        }
    }

    private Node top;

    public MinStackThree() {
    }

    public void push(int x) {
        Node newNode;
        if (top == null || top.min > x) {
            newNode = new Node(x, x);
        } else {
            newNode = new Node(x, top.min);
        }
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top != null) {
            top = top.next;
        }
        throw new EmptyStackException();
    }

    public int top() {
        if (top != null) {
            return top.data;
        }
        throw new EmptyStackException();
    }

    public int getMin() {
        if (top != null) {
            return top.min;
        }
        throw new EmptyStackException();
    }
}
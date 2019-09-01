package cc.jeris;

import java.util.EmptyStackException;

/**
 * MinStack: first implementation, using math encodings. Breaks for overley
 * large or small inputs
 * 
 * Problem Src: https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    int size;
    int top_pos;
    int min;
    int[] data;

    /** initialize your data structure here. */
    public MinStack() {
        size = 8;
        top_pos = -1;
        data = new int[size];
    }

    public void push(int x) {
        if (isFull()) {
            resize();
        }
        if (isEmpty()) {
            top_pos++;
            min = x;
            data[top_pos] = x;
            return;
        }
        top_pos++;
        if (x < min) {
            data[top_pos] = 2 * x - min;
            min = x;
        } else {
            data[top_pos] = x;
        }

    }

    public void pop() {
        int top = top();
        if (top < min) {
            min = 2 * min - top;
        }
        top_pos--;
    }

    public int top() {
        if (!isEmpty()) {
            return data[top_pos];
        }
        throw new EmptyStackException();
    }

    public int getMin() {
        if (!isEmpty()) {
            return min;
        }
        throw new EmptyStackException();
    }

    //// PRIVATE METHODS ////

    private boolean isFull() {
        return top_pos == size - 1;
    }

    private void resize() {
        int[] biggerStack = new int[size * 2];
        for (int i = 0; i < size; i++) {
            biggerStack[i] = data[i];
        }
        data = biggerStack;
        size *= 2;
    }

    private boolean isEmpty() {
        return top_pos == -1;
    }
}
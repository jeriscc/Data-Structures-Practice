package cc.jeris;

import java.util.EmptyStackException;

/**
 * MinStack: second implementation. Uses a second stack for the mins. Downside,
 * can have a lot of space overhead. Array implementation underneath is not very
 * neccessary.
 * 
 * Passes all tests. Time: 89% and 46ms.
 */
public class MinStackTwo {

    int size;
    int top_pos;
    int[] data;
    int mins_size;
    int mins_top;
    int[] mins;

    /** initialize your data structure here. */
    public MinStackTwo() {
        size = 8;
        top_pos = -1;
        data = new int[size];
        mins_size = 8;
        mins_top = -1;
        mins = new int[mins_size];
    }

    public void push(int x) {
        if (isFull()) {
            resize();
        }
        if (isEmpty()) {
            mins_top++;
            mins[mins_top] = x;
        } else if (x <= mins[mins_top]) {
            if (mins_top == mins_size - 1) {
                resizeMins();
            }
            mins_top++;
            mins[mins_top] = x;
        }
        top_pos++;
        data[top_pos] = x;
    }

    public void pop() {
        // No need to check for isEmpty() because top() does.
        int top = top();
        if (top == mins[mins_top]) {
            mins_top--;
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
            return mins[mins_top];
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

    private void resizeMins() {
        int[] biggerStack = new int[mins_size * 2];
        for (int i = 0; i < mins_size; i++) {
            biggerStack[i] = mins[i];
        }
        mins = biggerStack;
        mins_size *= 2;
    }

    public boolean isEmpty() {
        return top_pos == -1;
    }

}
package cc.jeris;

import java.util.ArrayList;

/**
 * Hello world!
 */
public final class MyStack<T> {
    private ArrayList<T> data = new ArrayList<T>();
    int size = 0;

    public void push(T x) {
        data.add(x);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T peak() {
        return data.get(size - 1);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return data.remove(size);
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

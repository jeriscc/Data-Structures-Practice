package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Stack;

/**
 * Unit test for simple App.
 */
public class StackTest {
    /**
     * Testing my stack
     */
    @Test
    public void testMyStack() {
        MyStack<Integer> s = new MyStack<Integer>();
        assertTrue(s.isEmpty());
        s.push(1);
        s.push(2);
        assertTrue(s.pop() == 2);
        assertFalse(s.isEmpty());
        assertTrue(s.size() == 1);
        assertTrue(s.peak() == 1);
        assertTrue(s.pop() == 1);
        assertTrue(s.pop() == null);
    }

    /**
     * How to use a standard stack
     */
    @Test
    public void testStack() {
        // 1. Initialize a stack.
        Stack<Integer> s = new Stack<>();
        // 2. Push new element.
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. Check if stack is empty.
        assertFalse(s.empty());
        // 4. Pop an element.
        s.pop();
        // 5. Get the top element.
        assert(s.peek() == 8);
        // 6. Get the size of the stack.
        assert(s.size() == 3);
    }
}

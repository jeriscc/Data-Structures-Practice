package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Stack;

/**
 * Test suite for Stack Implementations.
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


    @Test
    public void testMinStack() {
        MinStackTwo s = new MinStackTwo();
        s.push(-2);
        s.push(0);
        s.push(-3);
        assertTrue("Test min", s.getMin() == -3);
        // 4. Pop an element.
        s.pop();
        // 5. Get the top element.
        assertTrue("Test top", s.top() == 0);
        // 6. Get the size of the stack.
        assertTrue("Test min 2", s.getMin() == -2);
    }
}

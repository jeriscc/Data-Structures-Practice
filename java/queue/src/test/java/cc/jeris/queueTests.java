package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Unit test for my Circular Queue.
 */
public class queueTests {
    /**
     * Rigorous Test.
     */
    @Test
    public void testOne() {
        // Testing my Circular Queue
        MyCircularQueue my_q = new MyCircularQueue(3);
        my_q.enQueue(1);
        my_q.deQueue();
        my_q.enQueue(1);
        my_q.enQueue(1);

        assertTrue(my_q.size() == 1);
    }

    @Test
    public void standardQueueExample() {
        // Using the standard Java Queue
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        assertTrue("The first element is 13", q.peek() == 13);
        // 7. Get the size of the queue
        assertTrue("Queue size should be 3", q.size() == 3);
    }
}

package cc.jeris;

class MyCircularQueue {
    // Array of integers for storing data
    private int data[];
    private int size;

    // Pointers for head and tail of the queue
    private int p_head;
    private int p_tail;

    public MyCircularQueue(int k) {
        size = k;
        data = new int[size];
        p_head = -1;
        p_tail = -1;
    }

    /**
     * Insert an element into the queue. Return true if the operation is successful.
     */
    public boolean enQueue(int x) {
        if (p_tail == -1) {
            data[0] = x;
            p_head++;
            p_tail++;
            return true;
        } else if (isFull()) {
            return false;
        }
        p_tail = (p_tail + 1) % size;
        data[p_tail] = x;
        return true;
    };

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else if (p_head == p_tail) {
            p_head = -1;
            p_tail = -1;
            return true;
        }
        p_head = (p_head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : data[p_head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : data[p_tail];
    }

    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return p_head == -1;
    }

    public int size() {
        return p_tail > p_head ? p_tail - p_head : p_head - p_tail;
    }

    /** Checks whether the queue is full or not. */
    public boolean isFull() {
        return (p_tail + 1) % size == p_head;
    }
};
package cc.jeris;

import java.util.LinkedList;
import java.util.Queue;

/**
 * OpenLockTwo Uses two way BFS, boolean "hashset", and integer comparison Takes
 * advantage of the 10000 size limitation problem Inspired by 4ms 100% answer on
 * LeetCode
 *
 * Speed: 100% and 4ms
 * Memory: 36.1 MB
 */
public class OpenLockThree {
    boolean[] q1set = new boolean[10000];
    boolean[] q2set = new boolean[10000];
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /**
     * @param d the deadend strings
     * @param target the target string
     * @return min number of "turns" it takes to reach target from "0000"
     */
    public int openLock(String[] deadends, String target) {
        int t = Integer.parseInt(target);
        for (String d : deadends) {
            int dInt = Integer.parseInt(d);
            q1set[dInt] = q2set[dInt] = true;
            if (dInt == 0 || dInt == t)
                return -1;
        }
        q1set[0] = true;
        q2set[t] = true;
        int result = -1;
        int top;
        q1.add(0);
        q2.add(t);
        while (!q1.isEmpty()) {
            result++;
            int size = q1.size();
            // Check strings in this level
            for (int i = 0; i < size; i++) {
                top = q1.poll();
                if (q2set[top])
                    return result;
                advance(top);
            }
            swap();
        }
        return -1;
    }

    /**
     * Swaps the boolean arrays and queues by reference
     */
    public void swap() {
        boolean[] settmp = q1set;
        q1set = q2set;
        q2set = settmp;
        Queue<Integer> qtmp = q1;
        q1 = q2;
        q2 = qtmp;
    }

    /**
     * Adds neighboring, unvisited, and non-deadend numbers to the queue. Marks
     * those new numbers as visited.
     * 
     * @param top number to advance from
     */
    public void advance(int top) {
        int base = 1;
        while (base < 10000) {
            int digit = (top % (base * 10)) / base;
            int up = top + ((digit == 9) ? -9 : 1) * base;
            if (!q1set[up]) {
                q1set[up] = true;
                q1.add(up);
            }
            int down = top + ((digit == 0) ? 9 : -1) * base;
            if (!q1set[down]) {
                q1set[down] = true;
                q1.add(down);
            }
            base *= 10;
        }
    }
}
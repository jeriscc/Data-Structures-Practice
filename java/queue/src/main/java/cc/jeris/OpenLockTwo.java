package cc.jeris;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * OpenLockTwo Uses two way BFS
 * Speed: 96% and 22ms
 * Memory: 41.3 MB
 */
public class OpenLockTwo {
    private HashSet<String> deadends;
    private HashSet<String> q1set = new HashSet<>();
    private HashSet<String> q2set = new HashSet<>();
    private Queue<String> q1 = new LinkedList<String>();
    private Queue<String> q2 = new LinkedList<String>();

    public int openLock(String[] d, String target) {
        deadends = new HashSet<>(Arrays.asList(d));
        String start = "0000";
        if (deadends.contains(start) || deadends.contains(target))
            return -1;
        q1.add(start);
        q2.add(target);
        int result = -1;
        String top;
        while (!q1.isEmpty()) {
            result++;
            int size = q1.size();
            // Check strings in this level
            for (int i = 0; i < size; i++) {
                top = q1.poll();
                if (q2set.contains(top))
                    return result;
                advance(top);
            }
            swap();
        }
        return -1;
    }

    /**
     * Swaps the hashsets and queues by reference
     */
    public void swap() {
        HashSet<String> tempSet = q1set;
        q1set = q2set;
        q2set = tempSet;
        Queue<String> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /**
     * Adds neighboring, unvisited, and non-deadend strings to the queue. Marks
     * those new strings as visited.
     * 
     * @param top string to advance from
     */
    public void advance(String top) {
        StringBuilder tempBuilder;
        String temp;
        for (int j = 0; j < 4; j++) {
            tempBuilder = new StringBuilder(top);
            char c = top.charAt(j);
            tempBuilder.setCharAt(j, c == '9' ? '0' : (char) (c + 1));
            temp = tempBuilder.toString();
            if (!q1set.contains(temp) && !deadends.contains(temp)) {
                q1.add(temp);
                q1set.add(temp);
            }
            tempBuilder.setCharAt(j, c == '0' ? '9' : (char) (c - 1));
            temp = tempBuilder.toString();
            if (!q1set.contains(temp) && !deadends.contains(temp)) {
                q1.add(temp);
                q1set.add(temp);
            }
        }
    }
}
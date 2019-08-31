package cc.jeris;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * OpenLock
 * Uses one way BFS
 * Speed: 61% and 76ms
 * Memory: 41.6 MB
 */
class OpenLock {

    public static int openLock(String[] d, String target) {
        HashSet<String> deadends = new HashSet<>(Arrays.asList(d));
        Queue<String> q = new LinkedList<String>();
        String start = "0000";
        if (deadends.contains(start) || deadends.contains(target))
            return -1;
        q.add(start);
        int result = -1;
        String top;
        String temp;
        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            // Check strings in this level
            for (int i = 0; i < size; i++) {
                top = q.poll();
                if (top.equals(target))
                    return result;
                /**
                 * For each polled string, add adjacent unvisited strings to queue. Use
                 * StringBuilder for string manipulation perf
                 */
                StringBuilder tempBuilder;
                for (int j = 0; j < 4; j++) {
                    tempBuilder = new StringBuilder(top);
                    char c = top.charAt(j);
                    tempBuilder.setCharAt(j, c == '9' ? '0' : (char) (c + 1));
                    temp = tempBuilder.toString();
                    if (!deadends.contains(temp)) {
                        q.add(temp);
                        deadends.add(temp);
                    }
                    tempBuilder.setCharAt(j, c == '0' ? '9' : (char) (c - 1));
                    temp = tempBuilder.toString();
                    if (!deadends.contains(temp)) {
                        q.add(temp);
                        deadends.add(temp);
                    }
                }
            }
        }
        return -1;
    }
}
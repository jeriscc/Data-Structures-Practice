package cc.jeris;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * Daily Temperature, src: https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperature {
    /**
     * My solution. Speed: 72% and 41ms
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[T.length];
        s.push(0);
        int i = 1;
        while (i < T.length) {
            if (!s.isEmpty() && T[s.peek()] < T[i]) {
                int j = s.pop();
                result[j] = i - j;
            } else {
                s.push(i);
                i++;
            }
        }
        return result;
    }

    /**
     * My stack strategy implemented with array list
     * 
     * Speed: 85% and 14ms
     */
    public int[] dailyTempArrayList(int[] T) {
        ArrayList<Integer> a = new ArrayList<>();
        int[] result = new int[T.length];
        a.add(0);
        int i = 1;
        while (i < T.length) {
            int size = a.size();
            if (size != 0 && T[a.get(size - 1)] < T[i]) {
                int j = a.get(size - 1);
                result[j] = i - j;
                a.remove(size - 1);
            } else {
                a.add(i);
                i++;
            }
        }
        return result;
    }

    /**
     * My stack strategy implemented with ArrayDeque. Comparable perf to ArrayList
     * but cleaner code.
     * 
     * Speed: 87% and 13ms
     */
    public int[] dailyTempArrayDeque(int[] T) {
        Deque<Integer> s = new ArrayDeque<>();
        int[] result = new int[T.length];
        s.addFirst(0);
        int i = 1;
        while (i < T.length) {
            int size = s.size();
            if (size != 0 && T[s.peekFirst()] < T[i]) {
                int j = s.removeFirst();
                result[j] = i - j;
            } else {
                s.addFirst(i);
                i++;
            }
        }
        return result;
    }

    /**
     * Referencing top submission. Starts from the back and moves forward. No use of
     * "stack".
     * 
     * Speed: 99% and 3ms
     */
    public int[] dailyTempTwo(int[] T) {
        int[] res = new int[T.length];
        // The last one has to be zero.
        res[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            // The the later hotter, the previous must be 1
            if (T[i] < T[i + 1]) {
                res[i] = 1;
                // Otherwise, traverse foward by jumping to the next hotter temps
            } else {
                int j = i + 1;
                while (res[j] != 0) {
                    j += res[j];
                    if (T[i] < T[j]) {
                        res[i] = j - i;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
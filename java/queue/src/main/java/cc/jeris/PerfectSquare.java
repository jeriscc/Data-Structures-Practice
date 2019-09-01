package cc.jeris;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is my most optimed solution for BFS for the Perfect Squares Problem.
 * 
 * Problem Src: https://leetcode.com/problems/perfect-squares/
 * 
 * While other solutions used an accumulative approach, I decided to go with a
 * remainder appoach. This shrinks the loop to not run even check for large
 * perfect squares (rather breaking when the square is too large). Because there
 * is no `breaking` mechanism, we can search trying the largest perfect squares
 * first. This works well with the queue and allows us to quickly try "high
 * impact" perfect squres first.
 * 
 * Runtime: 38ms and 29% Memory Usage: 37 MB
 */
class PerfectSquare {
    Queue<Integer> q;
    HashSet<Integer> visited;

    /**
     * @param n integer number to calculate on
     * @return min number of perfect squares that sum to n
     */
    public int numSquares(int n) {
        // Filter out invalid entries
        if (n <= 0) {
            return 0;
        }
        int result = 0;

        // Initialize BFS queue and visited number HashSet
        q = new LinkedList<Integer>();
        visited = new HashSet<Integer>();
        q.add(n);

        // Initialize Integer Variables
        int size;
        int top;
        int remainder;

        while (!q.isEmpty()) {
            result++;
            size = q.size();
            while (size > 0) {
                top = q.poll();
                for (int r = getLargestRoot(top); r > 0; r--) {
                    remainder = top - r * r;
                    if (remainder == 0) {
                        return result;
                    } else if (remainder < 0) {
                        continue;
                    }
                    if (!visited.contains(remainder)) {
                        q.add(remainder);
                        visited.add(remainder);
                    }
                }
                size--;
            }
        }
        return -1;
    }

    private int getLargestRoot(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }
}
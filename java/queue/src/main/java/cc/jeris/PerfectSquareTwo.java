package cc.jeris;

import java.util.Arrays;

/**
 * Dynamic Programming Solution to Perfect Square Problem
 * 
 * Runtime: 23 ms and 60% Memory Usage: 35.3 MB
 */
public class PerfectSquareTwo {
    private int[] sums;

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        sums = new int[n + 1];
        Arrays.fill(sums, 5);
        sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                sums[i] = Math.min(sums[i], sums[i - j * j] + 1);
            }
        }
        return sums[n];
    }
}
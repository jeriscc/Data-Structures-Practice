package cc.jeris;

import java.util.Arrays;

/**
 * Dynamic Programming Solution to Perfect Square Problem
 * 
 * Runtime: 18 ms and 90% Memory Usage: 35.6 MB
 */
public class PerfectSquareTwo {
    private int[] sums;

    /**
     * @param n integer number to calculate on
     * @return min number of perfect squares that sum to n
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        sums = new int[n + 1];
        // Filled with 5 because the max num of squares is 4
        Arrays.fill(sums, 5);
        sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if (sqrt*sqrt == i) {
                sums[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++) {
                sums[i] = Math.min(sums[i], sums[i - j * j] + 1);
            }
        }
        return sums[n];
    }
}
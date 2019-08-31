package cc.jeris;

/**
 * NumIsland Problem src: https://leetcode.com/problems/number-of-islands/
 * 
 * Space complexity: constant
 * Time complexity: linear 100% and 1ms
 * 
 * Very cool solution:
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/discuss/56349/7-lines-Python-~14-lines-Java
 */
public class NumIslands {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of
     * islands. An island is surrounded by water and is formed by connecting
     * adjacent lands horizontally or vertically. You may assume all four edges of
     * the grid are all surrounded by water.
     * 
     * @param grid grid of land and sea
     * @return number of islands
     */
    public static int getNum(char[][] grid) {
        int result = 0;
        int i;
        int j;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * This is the DFS approach to marking. Can also be solved with BFS but there is
     * no time complexity gains from that approach. Also, the code will become more
     * sophisticated and the space complexity will increase.
     * 
     * 
     * @param grid the current land and sea
     * @param i position
     * @param j position
     * Marks island connected to (i,j) as sea
     */
    private static void markIsland(char[][] grid, int i, int j) {
        // Return if pointer is out of bounds or grid content equals '0'
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] != '1') {
            return;
        }
        // Mark/Sink that part of the island
        grid[i][j] = '0';

        // Recurse in neighboring locations
        markIsland(grid, i + 1, j);
        markIsland(grid, i - 1, j);
        markIsland(grid, i, j + 1);
        markIsland(grid, i, j - 1);
    }
}
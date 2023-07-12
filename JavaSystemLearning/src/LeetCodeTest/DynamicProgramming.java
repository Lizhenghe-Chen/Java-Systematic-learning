package LeetCodeTest;

import java.lang.reflect.Array;
import java.util.*;
import MyTools.PrintTools;

public class DynamicProgramming {
    public static void main(String[] args) {
    }

    static int Fibonacci(int n) {
        if (n <= 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * https://leetcode.com/problems/number-of-islands/description/
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                    PrintTools.println(grid.toString());
                }
            }
        }
        return count;
    }

    private void clearRestOfLand(char[][] grid, int i, int j) {
        // if the current position is out of bound or is not a land, return
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        // like the chain reaction, clear any connected island
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i, j + 1);
        clearRestOfLand(grid, i, j - 1);
        return;
    }

    /**
     * https://www.nowcoder.com/practice/1221ec77125d4370833fd3ad5ba72395?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37
     * 
     * @param n
     * @return
     */
    private static int dp(int n) {
        int num[] = new int[n + 1]; // n start from 1 month
        num[1] = 1;
        num[2] = 1;
        for (int i = 3; i <= n; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        System.out.println(Arrays.toString(num));
        return num[n];
    }
}

public class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1 - grid[i][j];
            }
        }
        int res = (1 << (n - 1)) * m;

        for (int j = 1; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                count += grid[i][j];
            }
            res += (1 << (n - j - 1)) * Math.max(count, m - count);
        }

        return res;
    }
}

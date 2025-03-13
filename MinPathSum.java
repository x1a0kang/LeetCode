public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    // 可以直接以grip作为dp数组
    public static int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // 第0行，[i][j]等于左边值加当前值
                else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                // 第0列，[i][j]等于上边值加当前值
                else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                // 其他行列，[i][j]等于上边值和左边值中的较小值加当前值
                else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

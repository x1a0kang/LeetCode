import java.util.ArrayList;
import java.util.List;

public class OrangesRotting {
    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        System.out.println(orangesRotting.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));
    }

    // 原则是广度优先搜索，同一时刻可能有多个腐烂的橘子从不同地方腐烂，这样会减少完全腐烂的时间，深度优先搜索无法处理这种情况
    public int orangesRotting(int[][] grid) {
        List<int[]> list = new ArrayList<>();
        // 记录新鲜的橘子数
        int fresh = 0;
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int size = list.size();

        // 判断fresh大于0，可以在最后一批次时，直接跳出循环，否则会多算一分钟
        while (size != 0 && fresh > 0) {
            // 每次处理一个批次，时间加一
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cur = list.removeFirst();
                // 分别处理四个方向，如果是新鲜的橘子，加入list，变腐烂，fresh减一
                for (int[] direction : directions) {
                    int row = cur[0] + direction[0];
                    int column = cur[1] + direction[1];
                    if (valid(grid, row, column)) {
                        grid[row][column] = 2;
                        list.add(new int[]{row, column});
                        fresh--;
                    }
                }
            }
            size = list.size();
        }
        if (fresh != 0) {
            return -1;
        }
        return minutes;
    }

    private boolean valid(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        return grid[i][j] == 1;
    }
}

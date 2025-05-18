import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        int total = matrix.length * matrix[0].length;
        int nextRow = 0;
        int nextCol = 0;
        int startRow = 0;
        int startCol = 0;
        int nextNum = matrix[nextRow][nextCol];
        int temp;
        while (count < total) {
            // 计算目标位置
            temp = nextRow;
            nextRow = nextCol;
            nextCol = n - 1 - temp;

            // 替换
            temp = nextNum;
            nextNum = matrix[nextRow][nextCol];
            matrix[nextRow][nextCol] = temp;

            count++;

            // 交换完n次回到最初的起点，如果本行还没换完，列加一；如果本行换完了，起点沿对角线前进一步
            if (nextRow == startRow && nextCol == startCol && count < total) {
                if (startCol == n - 2 - startRow) {
                    startRow++;
                    startCol = startRow;
                } else {
                    startCol++;
                }
                nextRow = startRow;
                nextCol = startCol;
                nextNum = matrix[nextRow][nextCol];
            }
        }
    }

    // 每轮都是4个位置互相交换，选择左上角四分之一遍历，就能交换全部
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                oneRound(matrix, i, j);
            }
        }
    }

    private void oneRound(int[][] matrix, int row, int col) {
        int n = matrix.length;
        // 记录前一个位置的数
        int pre = matrix[row][col];
        int temp;
        int nextRow;
        int nextCol;
        for (int i = 0; i < 4; i++) {
            // 计算下一个位置
            nextRow = col;
            nextCol = n - 1 - row;
            // 常规swap流程，temp中间值
            temp = matrix[nextRow][nextCol];
            matrix[nextRow][nextCol] = pre;
            pre = temp;
            // 更新row，col
            row = nextRow;
            col = nextCol;
        }
    }

    // 核心原理是先沿转置（沿对角线交换），再每行反转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 第一步：转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // 遍历对角线下方元素
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 第二步：行翻转
        for (int[] row : matrix) {
            for (int j = 0; j < n / 2; j++) { // 遍历左半元素
                int tmp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = tmp;
            }
        }
    }
}

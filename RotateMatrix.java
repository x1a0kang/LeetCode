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
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}

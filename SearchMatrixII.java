public class SearchMatrixII {
    // 从右上角开始，左边都是小于当前值的，下边都是大于当前值的。左下角同理
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 从右上角开始
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            // 小于目标值就往下
            if (matrix[i][j] < target) {
                i++;
            }
            // 大于目标值就往左
            else {
                j--;
            }
        }
        return false;
    }
}

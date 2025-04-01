public class SearchMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 先对第一列二分
        int start = -1;
        int end = matrix.length - 1;
        int index;
        int temp;
        while (start < end) {
            index = start + (end - start + 1) / 2;
            temp = matrix[index][0];
            if (temp == target) {
                return true;
            }
            if (temp < target) {
                start = index;
            } else {
                end = index - 1;
            }
        }
        // 小于第一行第一个数就是不存在
        if (start < 0) {
            return false;
        }
        // 选中行
        int row = start;
        // 再对列二分
        start = 0;
        end = matrix[0].length - 1;
        while (start <= end) {
            index = start + (end - start) / 2;
            temp = matrix[row][index];
            if (temp == target) {
                return true;
            }
            if (temp < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1}};
        System.out.println(searchMatrix(matrix, 0));
    }
}

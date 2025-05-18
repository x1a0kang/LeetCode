public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix s = new SearchMatrix();
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1}, {3}};
        System.out.println(s.searchMatrix2(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
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

    // 直接二分
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        int mid;
        int row;
        int col;
        while (left <= right) {
            // 计算mid
            mid = left + (right - left) / 2;
            // 计算mid在矩阵中的位置
            row = mid / m;
            col = mid % m;
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else
                return true;
        }
        return false;
    }
}

/**
 * 在二维矩阵中搜索字符串是否存在。
 * 使用深度优先搜索（DFS）算法，从矩阵的每个字符开始尝试匹配目标字符串。
 * 时间复杂度为 O(N * 3^L)，其中 N 是矩阵中的字符数，L 是目标字符串的长度。
 * 空间复杂度为 O(L)，主要由递归栈和 visited 数组占用。
 */
public class SearchStringInMatrix {

    /**
     * 检查二维矩阵中是否存在目标字符串。
     *
     * @param board 二维字符矩阵。
     * @param word  目标字符串。
     * @return 如果存在目标字符串则返回 true，否则返回 false。
     */
    public static boolean exist(char[][] board, String word) {
        // 检查输入是否为空或无效
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols]; // 记录已访问的字符位置

        // 遍历矩阵中的每个字符，尝试从该字符开始匹配目标字符串
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, visited, word, i, j, 0)) {
                    return true; // 如果找到匹配的字符串，立即返回 true
                }
            }
        }

        return false; // 遍历完所有字符后仍未找到匹配的字符串
    }

    /**
     * 深度优先搜索（DFS）递归函数，用于从当前字符位置开始匹配目标字符串。
     *
     * @param board   二维字符矩阵。
     * @param visited 记录已访问的字符位置。
     * @param word    目标字符串。
     * @param row     当前字符的行索引。
     * @param col     当前字符的列索引。
     * @param index   当前匹配的目标字符串的字符索引。
     * @return 如果从当前位置可以匹配到目标字符串则返回 true，否则返回 false。
     */
    private static boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        // 如果已匹配完整个目标字符串，返回 true
        if (index == word.length()) {
            return true;
        }

        // 检查边界条件和字符是否匹配
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true; // 标记当前字符为已访问

        // 向四个方向递归搜索下一个字符
        boolean found = dfs(board, visited, word, row - 1, col, index + 1) || // 上方
                dfs(board, visited, word, row + 1, col, index + 1) || // 下方
                dfs(board, visited, word, row, col - 1, index + 1) || // 左侧
                dfs(board, visited, word, row, col + 1, index + 1);   // 右侧

        visited[row][col] = false; // 回溯时取消标记

        return found; // 返回是否找到匹配的字符串
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        System.out.println("Word exists: " + exist(board, word)); // Output: true

        word = "SEE";
        System.out.println("Word exists: " + exist(board, word)); // Output: true

        word = "ABCB";
        System.out.println("Word exists: " + exist(board, word)); // Output: false
    }
}
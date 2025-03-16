public class WordExist {
    public static boolean res = false;
    public static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty() || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        // 记录已访问
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 剪枝，首字母不相同的位置，直接跳过
                if (board[i][j] == word.charAt(0)) {
                    dfs(board, word, i, j, 0);
                }
            }
        }
        return res;
    }

    public static void dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            res = true;
            return;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        // 剪枝，已访问的跳过
        if (visited[row][col]) {
            return;
        }
        if (board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            dfs(board, word, row + 1, col, index + 1);
            dfs(board, word, row - 1, col, index + 1);
            dfs(board, word, row, col + 1, index + 1);
            dfs(board, word, row, col - 1, index + 1);
            // 很关键，回溯要把当前节点改回false
            visited[row][col] = false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "a"));
    }
}

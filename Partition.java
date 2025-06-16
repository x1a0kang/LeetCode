import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("efe"));
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return res;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = dp(chars);
        dfs(chars, 0, dp);
        return res;
    }

    //  动态规划，记录从i到j的字符串是否是回文
    private boolean[][] dp(char[] chars) {
        boolean[][] dp = new boolean[chars.length][chars.length];
        // 对角线都是true
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        // 因为dp[i][j]依赖dp[i+1][j-1]，所以行从底向上遍历，并且最后一行可以直接跳过
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    // 因为左下半三角没处理，都是false，不要让dp[i + 1][j - 1]超过对角线，当j - i == 1时，dp[i + 1][j - 1]是false，所以这里要单独处理
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp;
    }

    private void dfs(char[] chars, int start, boolean[][] dp) {
        if (start > chars.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        // end从start开始遍历，每个字母单个都可以作为一个回文
        for (int end = start; end < chars.length; end++) {
            // 如果是回文，取这段字符串为一个元素，并继续递归
            if (dp[start][end]) {
                path.add(new String(chars, start, end - start + 1));
                dfs(chars, end + 1, dp);
                // 回溯
                path.removeLast();
            }
        }
    }
}

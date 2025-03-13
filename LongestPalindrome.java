import java.util.Arrays;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

    // 总体思想是：如果首尾两个字符不同，一定不是回文；如果相同，那么取决于去掉首尾后的子串是否是回文
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int len = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        String res = String.valueOf(charArray[0]);
        // 用行i表示起始字符，列j表示终止字符，因此对角线下方为无用值，对角线均为true
        // 去掉首尾后的子串即为[i+1,j-1]，位于[i][j]的左下方，因此行要从下往上遍历
        for (int i = len - 1; i >= 0; i--) {
            // 对角线为true
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                // 首尾不同为false
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                    continue;
                }
                // 如果首尾只相差1，一定是true
                if (j - i > 1) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = true;
                }

                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }
}

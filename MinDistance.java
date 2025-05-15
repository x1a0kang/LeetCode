public class MinDistance {
    // 只可以替换、插入和删除，其中插入和删除是相同的操作，只是从短到长和从长到短的区别，本题就以插入为例
    // dp[i][j]的距离可以由dp[i - 1][j - 1]加一步替换得到，也可以由dp[i - 1][j]或dp[i][j - 1]加一步插入得到
    // 有一种特殊情况是Word1[i] == Word2[j]，这时dp[i - 1][j - 1]不用加一步替换
    public int minDistance(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        int len1 = charArray1.length;
        int len2 = charArray2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 因为要用减一的位置推导，外围增加一层
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        int temp;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果两个字符不等，从dp[i - 1][j - 1]，dp[i - 1][j]和dp[i][j - 1]选一个最小值，再加一
                if (charArray1[i - 1] != charArray2[j - 1]) {
                    temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    temp = Math.min(temp, dp[i - 1][j - 1]);
                }
                // 如果两个字符相等，从dp[i - 1][j - 1] - 1，dp[i - 1][j]和dp[i][j - 1]选一个最小值，再加一
                // 因为这里dp[i - 1][j - 1]不用再加一，其他两个需要，所以先减去一
                else {
                    temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    temp = Math.min(temp, dp[i - 1][j - 1] - 1);
                }
                dp[i][j] = temp + 1;
            }
        }
        return dp[len1][len2];
    }
}

public class NumSquares {
    // 和零钱兑换问题类似
    public int numSquares(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = getNum(i, dp);
        }
        return dp[n];
    }

    public int getNum(int n, int[] dp) {
        int temp;
        int min = Integer.MAX_VALUE;
        // 这里直接通过i * i <= n寻找完全平方数，且不会像零钱兑换问题那样出现硬币面值大于目标数，或者无法凑出目标数等问题
        for (int i = 1; i * i <= n; i++) {
            temp = n - i * i;
            min = Math.min(min, dp[temp] + 1);
        }
        return min;
    }
}

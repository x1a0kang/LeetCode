import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2, 5, 10, 1}, 27));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = getNum(coins, i, dp);
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    // 找dp中目标amount减去当前面值的数，加1就是选当前面值的情况下需要的最少硬币数
    // 遍历所有面值的硬币，取最小硬币数
    public int getNum(int[] coins, int amount, int[] dp) {
        int temp;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin == amount) {
                return 1;
            }
            // temp为当前目标数减去当前硬币面值
            temp = amount - coin;
            // temp小于0跳过
            if (temp <= 0) {
                continue;
            }
            // dp[temp] == -1也跳过，否则dp[temp] + 1 = 0会造成错误
            if (dp[temp] == -1) {
                continue;
            }
            min = Math.min(min, dp[temp] + 1);
        }
        // 如果遍历完coin还是Integer.MAX_VALUE，表示没有符合的硬币组合，返回-1
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

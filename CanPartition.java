import java.util.Arrays;

public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{100, 4, 6}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        // 第一行只有数组第一个数的列可以为true
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            // 每行的第一列都是true，因为目标是0
            dp[i][0] = true;
            for (int j = 1; j <= target; j++) {
                // 如果当前数大于目标，肯定不选当前数，dp[i][j]等于上一行同一列dp[i - 1][j]
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 如果当前数大于目标，可以选当前数，
                // 如果不选，dp[i][j]等于上一行同一列dp[i - 1][j]
                // 如果选，目标数减去num[i]就是剩的数，看dp中上一行，剩的数的列是否是true
                else {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}

import java.util.Arrays;

public class CanPartition {
    public static void main(String[] args) {
        canPartition(new int[]{100, 4, 6});
    }

    public static boolean canPartition(int[] nums) {
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
            dp[i][0] = true;
            for (int j = 1; j <= target; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[nums.length - 1][target];
    }
}

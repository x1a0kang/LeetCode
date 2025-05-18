public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray.maxSubArray(nums));
    }

    // 核心原理：前缀和，前缀和的关键是，需要的子数组，是当前前缀和减去之前前缀和的差值
    public int maxSubArray(int[] nums) {
        // 当前前缀和
        int preSum = 0;
        // 之前的最小前缀和
        int minPreSum = 0;
        int max = nums[0];
        for (int num : nums) {
            // 计算当前前缀和
            preSum += num;
            // 当前前缀和减去之前的最小前缀和，计算以当前位置为结束的子数组的最大和
            max = Math.max(max, preSum - minPreSum);
            // 更新最小前缀和
            minPreSum = Math.min(preSum, minPreSum);
        }
        return max;
    }
}

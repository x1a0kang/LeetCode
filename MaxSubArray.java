public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int preSum = 0;
        int max = nums[0];
        for (int num : nums) {
            if (preSum < 0) {
                preSum = 0;
            }
            preSum += num;
            max = Math.max(max, preSum);
        }
        return max;
    }
}

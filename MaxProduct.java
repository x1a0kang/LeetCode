public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int result = nums[0];
        // 因为可能有负数，导致之前的负数乘积和当前数相乘后成为整数，这里维护两个数组，一个最大值一个最小值
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 先比较用max和min分别乘以nums[i]，再比较和nums[i]本身
            maxDp[i] = Math.max(Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]), nums[i]);
            minDp[i] = Math.min(Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]), nums[i]);
            // result只需要和maxDp的值比较
            result = Math.max(result, maxDp[i]);
        }
        return result;
    }
}

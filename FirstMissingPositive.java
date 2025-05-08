public class FirstMissingPositive {
    // 核心思想就是：第一个未出现的正数，在[1,N+1]的左闭右闭区间中
    // 如果不要求空间复杂度，可以用哈希表保存数组内的所有元素，然后从1开始遍历
    // 本题要求空间复杂度是常数，就在原数组上操作，不在[1,N+1]区间的元素忽略，在的放到对应的位置上，再从头遍历，对应位置不是对应元素的就是第一个缺失的正数
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果nums[i]在[1,N]区间内，把它换到num[i]-1的位置上，如果换过来的数还是满足，一直换，换到目标位置已经是正确的数了，或者当前数不在这个区间为止
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

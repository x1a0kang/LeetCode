public class NextPermutation {
    // 首先字典序可以改为组成数字的大小，这样更容易理解，如123，下一个就是132
    // 也就是想让数字变大，但要让变大的数值尽可能小，那就要从低位开始改变，也就是从右侧开始
    // 1. 首先从右往左找到第一个变小的数，比如123，2就是第一个变小的数，132，1就是第一个变小的数
    // 2. 然后再从右往左，找比上一步的数只大一点点的数，比如123，3就是比2大一点点的数，132，2就是比1大一点点的数
    // 3. 再交换上述两步找到的数的位置，就变成了132，231
    // 4. 这样还不够，步骤2中寻找数的过程，就是寻找第一个降序数的过程，也就是说找到的数的右侧，从右向左是升序排列的，在交换之后，整个数组组成的数已经变大了，但是并不是只变大了一点点，
    // 右侧的序列是以最大值的情况排列的，因此要把右边的序列反转，让它从左往右升序排列，这样组成的就是最小值，也就是整个数组变大，但是变大的数值尽可能小
    public static void nextPermutation(int[] nums) {
        // 先找第一个降序数，等于也属于非降序
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        // 如果第一个数不是0，寻找右侧大于第一个数的最小值
        // 如果是0就是最大值的情况，整个数组反转即可
        if (index >= 0) {
            int right = nums.length - 1;
            // 因为index的右边是从右往左递增的，那从右往左第一个大于nums[index]的数就是最小值
            while (right > index) {
                if (nums[right] > nums[index]) {
                    break;
                }
                right--;
            }
            swap(nums, index, right);
        }
        // 反转index之后的数组
        reverse(nums, index + 1, nums.length - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        nextPermutation(nums);
    }
}

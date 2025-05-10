public class SearchMinInRotateOrderList {
    // 总体原则是，旋转后，右半部分的最大值是小于左半部分的最小值的
    // 所以如果中点的值大于右边，说明中点左边的数全部都大于最小值，最小值在中点右边，且左边界可以跳过中点
    // 如果中点的值小于右边，说明中点右边的数全部大于最小值，最小值在中点左边，但当前数可能就是最小值，所以右边界不能跳过中点
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                // 右边界不能跳过中点
                right = mid;
            } else {
                // 左边界可以跳过中点
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        System.out.println(findMin(nums));
    }
}

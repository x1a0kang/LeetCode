public class SearchRotateOrderList {
    public static int search(int[] nums, int target) {
        // 先找到旋转的点，也就是找到数组中的最小值
        int minIndex = findMin(nums);
        int res;
        // 判断target在最小值的左边还是右边，再用二分法定位
        if (target >= nums[minIndex] && target <= nums[nums.length - 1]) {
            res = findTarget(nums, target, minIndex, nums.length - 1);
        } else {
            res = findTarget(nums, target, 0, minIndex - 1);
        }
        return res;
    }

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
        return left;
    }

    // 二分法查找target是否存在
    public static int findTarget(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 3));
    }
}

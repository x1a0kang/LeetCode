public class SearchRotateOrderList {
    // 原则是判断哪边是递增的，检查递增范围的左右边界，如果target在该范围内，则选择递增的一边，反之取另外一边
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果mid大于right，说明右侧是非递增的，左侧是递增的
            if (nums[mid] > nums[right]) {
                // 判断是否在左侧递增区间内，在则直接查找
                if (nums[left] <= target && target <= nums[mid]) {
                    return findTarget(nums, target, left, mid);
                }
                // 不在则更新左边界
                else {
                    left = mid + 1;
                }
            }
            // 如果mid小于right，说明右侧是递增的，左侧是非递增的
            else {
                // 判断是否在右侧递增区间内，在则直接查找
                if (nums[mid] <= target && target <= nums[right]) {
                    return findTarget(nums, target, mid, right);
                }
                // 不在则更新右边界
                else {
                    right = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
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
        int[] nums = new int[]{1, 3};
        System.out.println(search(nums, 3));
    }
}

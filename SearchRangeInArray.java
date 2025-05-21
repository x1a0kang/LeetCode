import java.util.Arrays;

public class SearchRangeInArray {
    public static void main(String[] args) {
        SearchRangeInArray searchRangeInArray = new SearchRangeInArray();
        int[] nums = {2, 2};
        int[] searchRange = searchRangeInArray.searchRange(nums, 2);
        System.out.println(Arrays.toString(searchRange));
    }

    // 想法是两边二分查找，分别找到左右边界，关键点在于第一次找到目标值时不要跳出循环，一直找到两个边界相遇为止
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int bound = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 每次都记录边界的位置，下次可能就不是target了
                bound = mid;
                // 找到边界也让右指针左移，找左边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[0] = bound;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 每次都记录边界的位置，下次可能就不是target了
                bound = mid;
                // 找到边界也让左指针右移，找右边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[1] = bound;
        return result;
    }

    // 想法是先找到target，然后分别向左右移动找到边界。但是极端情况下，比如数组的所有值都是target，时间复杂度会来到On
    public int[] my(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (nums[mid] != target) {
            return new int[]{-1, -1};
        }
        start = mid;
        end = mid;
        while (start >= 0) {
            if (nums[start] == target) {
                start--;
            } else {
                break;
            }
        }
        while (end < nums.length) {
            if (nums[end] == target) {
                end++;
            } else {
                break;
            }
        }
        return new int[]{start + 1, end - 1};
    }
}

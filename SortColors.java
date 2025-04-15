public class SortColors {
    // 可以排序，可以先遍历一遍用哈希表计数，再一遍赋值，但是还有一遍遍历就完成的方法
    // 两个指针，一个指向0的下一个位置，起始是0，一个指向2的下一个位置，起始是length-1
    // 当前指针从第一个位置开始，当前位置是0，则与左指针交换，左指针向右移动，当前位置也要向前移动
    // 当前位置是2，则与右指针交换，右指针向左移动，当前位置不变
    // 当前位置是1，不做处理，当前指针向前移动
    // 直到当前指针和右指针相遇，结束遍历，右指针之后已经全部是2了
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
            } else {
                cur++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
    }
}

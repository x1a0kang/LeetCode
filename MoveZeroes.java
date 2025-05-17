import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 如果把0往后移，需要向后寻找，时间复杂度更高，可以反过来理解为把非0往前移
    public void moveZeroes(int[] nums) {
        // 因为顺序不能改变，用index标识下一个非零元素应该在的位置，cur用来遍历
        int index = 0;
        int cur = 0;
        while (cur < nums.length) {
            // 如果当前位置不是0，往前交换到index位置，index向后移动一位
            // 如果当前位置是0，不交换位置，index也不变，遇到下一个不是0的位置，就会交换到这个0的位置来
            if (nums[cur] != 0) {
                swap(nums, cur, index);
                index++;
            }
            cur++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

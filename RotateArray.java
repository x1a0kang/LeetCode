import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        // 需要交换的个数
        int n = nums.length;
        // 本轮交换的起始位置
        int start = 0;
        // 下一个要交换的位置上的数
        int next = nums[0];
        // 下一个要交换的位置
        int nextIndex = 0;

        int temp;
        while (n > 0) {
            // 当前位置要交换到的目标位置，也是下一个要交换的位置
            nextIndex = (nextIndex + k) % nums.length;
            temp = nums[nextIndex];
            nums[nextIndex] = next;
            next = temp;
            // 交换完，n减一
            n--;

            // 会有一直移动，本轮最后一个元素移动到起始位置上的情况，这时候起始位置前进一位，跳出循环
            if (nextIndex == start && n > 0) {
                start++;
                nextIndex = start;
                next = nums[nextIndex];
            }
        }
    }
}

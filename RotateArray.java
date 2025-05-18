import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {-1, -100, 3, 99};
        rotateArray.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 轮转 k 次等于轮转 k % n 次，因为轮转n次就是不变
        k %= n;
        // 先整个数组反转
        reverse(nums, 0, n - 1);
        // 然后前k个和后k到n个分别反转
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        // 左右指针互换位置
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}

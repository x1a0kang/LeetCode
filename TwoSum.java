import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        Arrays.stream(ints).forEach(System.out::println);
    }

    // 双指针，每次只从当前点往后，不会重复
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

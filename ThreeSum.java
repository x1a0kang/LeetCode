import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
//        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 三数之和要先排序
        Arrays.sort(nums);
        int sum;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            // 如果和前一个数相同，直接跳过，不找重复答案
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针一左一右
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right] + nums[i];
                // 因为是排完序的，如果和大了，就减小右边的值，和小了，就增加左边的值
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    ans.add(list);
                    // sum等于0后，还要继续循环，因为可能有这种[-3,-2,-2,-1,-1,4,4,5,5]
                    left++;
                    right--;
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return ans;
    }
}

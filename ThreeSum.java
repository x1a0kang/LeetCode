import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
//        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = groupAnagrams(nums);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> groupAnagrams(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int sum;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    ans.add(list);
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

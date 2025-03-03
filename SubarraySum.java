import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 前缀和为零的数组，默认是1，就是空数组
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            Integer temp = map.get(sum - k);
            if (temp != null) {
                count += temp;
            }
        }
        return count;
    }
}

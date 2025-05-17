import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 1};
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(nums, 8));
    }

    // 核心原理是浅前缀和，如果当前前缀和是sum，之前出现过sum-k的前缀和，就有一个子数组的和是k
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // 记录已经得到过的sum值
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化前缀和为 0 的出现次数为 1
        map.put(0, 1);
        for (int num : nums) {
            // 计算当前前缀和
            sum += num;
            // 判断前缀和+当前数等不等于k
            Integer temp = map.get(sum - k);
            if (temp != null) {
                count += temp;
            }
            // 前缀和为零的数组，默认是1，就是空数组
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

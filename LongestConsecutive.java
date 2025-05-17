import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int temp;
        // 这里一定要遍历set，如果原数组是[1,1,1,2,3,5]，会遍历三遍1
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            temp = num + 1;
            while (set.contains(temp)) {
                temp++;
            }
            res = Math.max(res, temp - num);
        }
        return res;
    }
}

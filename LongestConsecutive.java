import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    /**
     * 寻找数组中最长的连续数字序列长度
     * @param nums 输入的整数数组
     * @return 最长连续数字序列的长度
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int temp;
        /*
         * 这里一定要遍历set，如果原数组是[1,1,1,2,3,5]，会遍历三遍1
         * 遍历set时，如果当前数字前一个不存在（即num-1不在集合中），则开始计算连续序列
         * 然后不断递增temp直到在集合中找不到对应的值，计算连续序列的长度
         */
        for (int num : set) {
            // 如果前一个数存在，跳过，因为前一个已经算过了
            if (set.contains(num - 1)) {
                continue;
            }
            // 如果前一个不存在，开始往后找0
            temp = num + 1;
            while (set.contains(temp)) {
                temp++;
            }
            res = Math.max(res, temp - num);
        }
        return res;
    }
}

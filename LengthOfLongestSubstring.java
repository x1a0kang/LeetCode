import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("u"));
    }

    // 核心思想是滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] charArray = s.toCharArray();
        int left = 0;
        int max = 0;
        // map保存key为字符，value为出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < charArray.length; right++) {
            // 如果当前字符在map中存在，并且位置大于left，left向右移动（因为map内的元素不删除，可能有在窗口之外的元素和窗口内的元素重复，这种不用管）
            if (map.containsKey(charArray[right]) && map.get(charArray[right]) > left) {
                left = map.get(charArray[right]) + 1;
            }
            map.put(charArray[right], right);
            // 每次扩大窗口，更新max
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

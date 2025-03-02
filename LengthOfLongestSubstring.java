import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("u"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] charArray = s.toCharArray();
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                start = Math.max(map.get(charArray[i]) + 1, start);
            }
            map.put(charArray[i], i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}

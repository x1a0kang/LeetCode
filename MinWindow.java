import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }
        // 构建T的字符map
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        String res = "";
        // 左右指针表示滑动窗口的边界
        for (int right = 0; right < s.length(); right++) {
            char c = charArray[right];
            // 已有字符计数
            if (tMap.containsKey(c)) {
                map.put(charArray[right], map.getOrDefault(charArray[right], 0) + 1);
            }
            // 如果已有字符满足了目标字符串的要求，向左收缩边界
            while (check(tMap, map) && left <= right) {
                // 更新res
                if (res.isEmpty() || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                // 收缩左边界，map中的计数更新
                char c1 = charArray[left];
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) - 1);
                }
                left++;
            }
        }
        return res;
    }

    private boolean check(Map<Character, Integer> tMap, Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            } else {
                if (map.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}

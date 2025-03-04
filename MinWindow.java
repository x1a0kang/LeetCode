import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }
        // 构建T的字符map
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int left = 0;
        String res = "";
        String temp;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                list.add(right);
            }

            while (check(tMap, map) && left <= right) {
                temp = s.substring(left, right + 1);
                if (res.isEmpty() || temp.length() < res.length()) {
                    res = temp;
                }
                char c1 = s.charAt(left);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) - 1);
                }
                left = getLeft(left, list);
            }
        }
        return res;
    }

    private static boolean check(Map<Character, Integer> tMap, Map<Character, Integer> map) {
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

    private static int getLeft(int left, LinkedList<Integer> list) {
        while (!list.isEmpty()) {
            Integer first = list.removeFirst();
            if (first == left) {
                continue;
            }
            return first;
        }
        return left + 1;
    }
}

import java.util.*;

public class FindAnagrams {
    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abaacbabc", "abc");
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tempMap = new HashMap<>();
        int left;
        int right;
        for (right = 0; right < s.length(); right++) {
            tempMap.put(s.charAt(right), tempMap.getOrDefault(s.charAt(right), 0) + 1);
            left = right - p.length() + 1;
            // 窗口长度不足 p.length()
            if (left < 0) {
                continue;
            }
            if (equals(map, tempMap)) {
                ans.add(left);
            }
            tempMap.put(s.charAt(left), tempMap.getOrDefault(s.charAt(left), 0) - 1);
        }
        return ans;
    }

    private static boolean equals(Map<Character, Integer> map, Map<Character, Integer> tempMap) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!tempMap.containsKey(entry.getKey())) {
                return false;
            }
            if (!Objects.equals(entry.getValue(), tempMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计 p 的每种字母的出现次数
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 s' 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++; // 统计 p 的字母
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < 0) { // 窗口长度不足 p.length()
                continue;
            }
            if (Arrays.equals(cntS, cntP)) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
            cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }
}

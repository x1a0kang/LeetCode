import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strList = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        lists.forEach(System.out::println);
    }

    public static List<List<String>> groupAnagrams(String[] strList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strList) {
            char[] array = str.toCharArray();
            // 相同字符的字符串排序后相同
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

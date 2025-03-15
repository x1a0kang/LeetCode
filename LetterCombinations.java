import java.util.*;

public class LetterCombinations {
    public static List<String> res;
    public static StringBuilder sb;

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        sb = new StringBuilder();
        Map<Character, List<String>> letterMap = getLetterMap();
        List<List<String>> letterList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            letterList.add(letterMap.get(digits.charAt(i)));
        }
        dfs(letterList, 0);
        return res;
    }

    public static void dfs(List<List<String>> letterList, int num) {
        if (sb.length() == letterList.size()) {
            res.add(sb.toString());
            return;
        }
        List<String> list = letterList.get(num);
        for (String s : list) {
            sb.append(s);
            dfs(letterList, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static Map<Character, List<String>> getLetterMap() {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        return map;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }
}

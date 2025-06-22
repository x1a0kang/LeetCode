import java.util.*;

public class LetterCombinations {
    private List<String> res;
    private StringBuilder sb;

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("23");
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        sb = new StringBuilder();
        List<List<String>> letterList = new ArrayList<>();
        // 获取每个数字的待选列表
        for (int i = 0; i < digits.length(); i++) {
            letterList.add(getLetterList(digits.charAt(i)));
        }
        dfs(letterList, 0);
        return res;
    }

    // 每个数字的待选列表内只能选一个，num表示该选第几个数字的待选列表
    public void dfs(List<List<String>> letterList, int num) {
        // 已选的字符数和输入的字符数相同时，说明已选完所有字符，加入结果集
        if (sb.length() == letterList.size()) {
            res.add(sb.toString());
            return;
        }
        // 遍历当前待选列表
        List<String> list = letterList.get(num);
        for (String s : list) {
            // 添加当前字符
            sb.append(s);
            // 递归
            dfs(letterList, num + 1);
            // 删除当前字符，最后一个字符
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> getLetterList(Character c) {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        return map.get(c);
    }
}

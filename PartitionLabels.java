import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        // 先一遍遍历，记录所有字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            map.put(charArray[i], i);
        }
        List<Integer> res = new ArrayList<>();
        // 记录片段起始位置
        int start = 0;
        // 记录片段结束位置
        int end = 0;
        // 再一遍遍历，如果当前字符最后出现的位置大于end，说明还有往后延伸，end每次取相对大的那个
        // 如果end和当前位置相等，说明到了截取位置，计算长度，移动起始点
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(charArray[i]));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}

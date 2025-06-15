import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put(' ', 0);
        int sum = 0;
        char pre = ' ';
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            // 加上当前数
            sum += map.get(c);
            // 如果当前数大于前一个数，说明是4或9，而且上一个数已经加过一次，所以要减去两次
            if (map.get(pre) < map.get(c)) {
                sum -= 2 * map.get(pre);
            }
            // 记录上一个数
            pre = c;
        }
        return sum;
    }
}

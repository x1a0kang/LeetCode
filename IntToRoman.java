public class IntToRoman {
    // 每次都从value里找最大值，然后减去这个值
    // 需要记录的就是1，4，5，9
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                // 找到最大值，减去这个值
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}

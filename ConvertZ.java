import java.util.ArrayList;
import java.util.List;

public class ConvertZ {
    public static void main(String[] args) {
        ConvertZ convertZ = new ConvertZ();
        System.out.println(convertZ.convert2("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        char[] charArray = s.toCharArray();
        if (numRows == 1) return s;
        // 初始化，每行一个StringBuilder
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 1;
        // 先把第一个字符加入第一行，因为后面的遍历过程不能包含第一个字符的情况
        list.getFirst().append(charArray[0]);
        while (i < charArray.length) {
            // 从第1行开始向下填充，直到最后一列
            for (int j = 1; j < numRows; j++) {
                if (i >= charArray.length) {
                    break;
                }
                StringBuilder stringBuilder = list.get(j);
                stringBuilder.append(charArray[i]);
                i++;
            }
            // 从倒数第二列开始向上填充，直到第0行
            for (int j = numRows - 2; j >= 0; j--) {
                if (i >= charArray.length) {
                    break;
                }
                StringBuilder stringBuilder = list.get(j);
                stringBuilder.append(charArray[i]);
                i++;
            }
        }
        // 拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : list) {
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }

    public String convert2(String s, int numRows) {
        char[] charArray = s.toCharArray();
        if (numRows == 1) return s;
        // 初始化，每行一个StringBuilder
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int row = 0;
        // 初始化是-1很关键，因为遇到0行时，会调转方向
        int direction = -1;
        // 根据direction计算行数，到0或最后一行时调转方向
        for (char c : charArray) {
            list.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                direction = -direction;
            }
            row += direction;
        }
        // 拼接字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : list) {
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }
}

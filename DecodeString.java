import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DecodeString {
    static Deque<String> stack = new ArrayDeque<>();

    // 数字和字母公用了一个栈，也可以分开用两个，这里公用一个，栈的类型就要定为String
    // 很恶心的是如果直接把所有字符入栈，出来之后还要倒序，而StringBuilder并没有addFirst，所以要用list接收弹出的字符，再转成字符串
    // 核心思想就是所有的字符都要进栈再弹出，一个方括号内的字符弹出拼接好之后，再入栈，直到最后所有括号处理完毕后，弹出栈内所有字符，拼接成答案
    public static String decodeString(String s) {
        // 处理数字，比如233这种大于一位的数字
        StringBuilder time = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c >= '0' && c <= '9') {
                time.append(c);
            } else if (c == '[') {
                // 遇到左括号，把当前累积的数字先加入，没有数字使用1占位
                if (!time.isEmpty()) {
                    stack.push(time.toString());
                } else {
                    stack.push("1");
                }
                // 加入左括号
                stack.push(String.valueOf(c));
                time.setLength(0);
            } else if (c == ']') {
                // 遇到右括号，从栈里弹出字符拼接，再入栈
                String fromStack = getFromStack();
                stack.push(fromStack);
            } else {
                // 遇到字符，直接加入
                stack.push(String.valueOf(c));
            }
        }
        // 最后，弹出栈里的所有内容
        return getFromStack();
    }

    public static String getFromStack() {
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            // 遇到左括号，本轮弹出结束
            if (pop.equalsIgnoreCase("[")) {
                break;
            } else {
                // 用list的addFirst，反转栈弹出的倒序
                list.addFirst(pop);
            }
        }
        // 左括号的前方一定有一个数字，如果当前栈为空，默认为1，在ab2[c]这种情况时，最终弹出会出现stack为空的情况
        int time = stack.isEmpty() ? 1 : Integer.parseInt(stack.pop());
        String temp = listToString(list);
        return temp.repeat(time);
    }

    public static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("[abc][def]"));
    }
}

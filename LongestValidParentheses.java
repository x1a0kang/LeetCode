import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
    }

    // 最关键的是想到在栈内保存数组的下标，而不是括号
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        char temp;
        int res = 0;
        // 这里是最难想到的地方，因为如果有一段()()这样的串，前两个括号弹出后，得到的长度是2，栈内空了，后两个括号再弹出，算出的结果还是2，但实际应该是4
        // 所以需要把连续子串开始的前一个位置放进栈内，每次都把满足的括号弹出，再计算当前位置和前一个位置的差值，这样算出来的才是连续的长度
        // 刚开始没有前置位置，用-1占位
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            temp = charArray[i];
            if (temp == '(') {
                stack.push(i);
            } else {
                // 这里要先pop，再计算当前位置和前一个位置的差值
                stack.pop();
                // 如果这里栈为空了，说明前面的都是满足条件的括号，但多了一个)不满足，比如())()，所以连续串断了，把当前位置进栈，作为下一个连续串的前置位置
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}

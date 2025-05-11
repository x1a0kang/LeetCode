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

    // 动态规划分两种情况
    public int longestValidParenthesesDp(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int[] dp = new int[charArray.length];
        char temp;
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < charArray.length; i++) {
            temp = charArray[i];
            if (temp == ')') {
                if (charArray[i - 1] == '(') {
                    // 左括号(的前一个位置的值加2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    // 如果前一个是右括号，要看前一个右括号的左括号位置是不是左括号
                    int lastLeftBracket = i - dp[i - 1] - 1;
                    if (lastLeftBracket >= 0 && charArray[lastLeftBracket] == '(') {
                        // 等于dp前一个右括号的值，加上dp前一个右括号的左括号的前一个位置的值，再加上2
                        if (lastLeftBracket - 1 >= 0) {
                            dp[i] = dp[i - 1] + dp[lastLeftBracket - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}

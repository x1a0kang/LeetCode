import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        int pop;
        for (int i = 0; i < temperatures.length; i++) {
            // 检查当前栈顶元素是否小于当前元素，是则弹出栈顶元素，当前元素即是栈顶元素之后的第一个更高的温度，距离为i-pop
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                pop = stack.pop();
                result[pop] = i - pop;
            }
            // 一直弹出所有更小的栈顶元素，最后把当前下标放入栈内
            stack.push(i);
        }
        return result;
    }
}

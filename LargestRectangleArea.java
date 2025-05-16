import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    // 核心是单调栈，栈内保存的是下标
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = init(heights);
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            // 保持栈内的单调递增，每个元素进入时，弹出前面所有值更大的元素，然后计算弹出元素的面积
            while (!stack.isEmpty() && list.get(stack.peek()) > list.get(i)) {
                // 柱的高就是弹出的当前元素的值，宽的左边界是当前栈顶的元素，右边界是当前要入栈的元素
                res = Math.max(res, list.get(stack.pop()) * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return res;
    }

    // 在原数组的基础上首尾新增两个0元素，可以使边界处理更简单
    public List<Integer> init(int[] heights) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int height : heights) {
            res.add(height);
        }
        res.add(0);
        return res;
    }
}

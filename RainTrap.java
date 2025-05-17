import java.util.ArrayDeque;
import java.util.Deque;

public class RainTrap {
    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 3, 2, 5};
        RainTrap trap = new RainTrap();
        int i = trap.rainTrap(nums);
        System.out.println(i);
    }

    // 核心是单调栈，栈内保存的是下标
    public int rainTrap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int temp;
        int h;
        for (int i = 0; i < height.length; i++) {
            // 栈内保持递增，注意这里是大于等于，相等的也弹出，否则在后续计算时会麻烦
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                temp = stack.pop();
                // 可能遇到最左边，最左边无法储存雨水，直接跳出
                if (stack.isEmpty()) {
                    break;
                }
                // 计算高度，取左右两边的较小值，减去弹出元素的高度，如果前面弹出的是相等的，这里高度会是0，对面积没有影响
                h = Math.min(height[i], height[stack.peek()]) - height[temp];
                res += h * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }

    // 一层一层计算
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int base = 0;
        while (left < right) {
            // 先找到左右边界，左右比base矮的存不了水
            if (height[left] <= base) {
                left++;
                continue;
            }
            if (height[right] <= base) {
                right--;
                continue;
            }
            // 算出本层的高度，左右取更小的那个，减去base
            int min = Math.min(height[left], height[right]) - base;
            // 总面积就是高度乘以左右间的距离
            int total = min * (right - left - 1);
            // 再用总面积减去墙占用的面积，就是base层存水的面积
            for (int i = left + 1; i < right; i++) {
                // 如果当前位置高度减去层数，小于本层的高度，说明低于水平线，甚至低于层数，所以取其和0的更大值
                if (height[i] - base < min) {
                    total -= Math.max(height[i] - base, 0);
                } else {
                    total -= min;
                }
            }
            // 总和加上本层的计算
            sum += total;
            // 层数加上本层的高度
            base += min;
        }
        return sum;
    }
}

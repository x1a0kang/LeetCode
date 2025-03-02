public class RainTrap {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int i = trap(nums);
        System.out.println(i);
    }

    // 一层一层计算
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int base = 0;
        while (left < right) {
            if (height[left] <= base) {
                left++;
                continue;
            }
            if (height[right] <= base) {
                right--;
                continue;
            }
            int min = Math.min(height[left], height[right]) - base;
            int total = min * (right - left - 1);
            for (int i = left + 1; i < right; i++) {
                if (height[i] - base < min) {
                    total -= Math.max(height[i] - base, 0);
                } else {
                    total -= min;
                }
            }
            sum += total;
            base += min;
        }
        return sum;
    }
}

public class MaxAreaWater {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(nums);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        // 一左一右，每次移动较短的那个板
        // 较短的板不变，较长的板再怎么变也不会让面积变得更大
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
        int max = 0;
        int temp;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                temp = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}

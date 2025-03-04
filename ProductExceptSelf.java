import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1});
        System.out.println(Arrays.toString(res));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return new int[0];
        if (nums.length == 1) return nums;
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int temp = 1;
        for (int i = 0; i < res.length; i++) {
            left[i] = temp;
            temp *= nums[i];
        }

        temp = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            right[i] = temp;
            temp *= nums[i];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

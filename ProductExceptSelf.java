import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        int[] res = p.productExceptSelf(new int[]{1});
        System.out.println(Arrays.toString(res));
    }

    // 核心是三遍遍历，先求出每个位置左边的乘积，再求出右边的乘积，最后每个位置左右乘积相乘
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return new int[0];
        if (nums.length == 1) return nums;
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // temp是累计的乘积
        int temp = 1;
        // 先求左边所有位置的乘积
        for (int i = 0; i < res.length; i++) {
            left[i] = temp;
            temp *= nums[i];
        }

        temp = 1;
        // 再求右边所有位置的乘积
        for (int i = res.length - 1; i >= 0; i--) {
            right[i] = temp;
            temp *= nums[i];
        }

        // 最后左右相乘
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

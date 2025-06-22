public class CanJump {

    // 记录最远能够到达的位置，如果当前位置大于最远能够到达的位置，则返回false；如果小于就可以继续往前，直到最后一个元素。
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int end = nums.length - 1;
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (i > max) {
                return false;
            }
            if (nums[i] + i >= end) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }
}

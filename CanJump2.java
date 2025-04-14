public class CanJump2 {
    // 贪心算法，从第一个位置开始，到num[0]位置为止，一定要跳一次，否则无法向后继续。所以用max记录最远能跳到的位置，end记录到这里为止一定要跳一次的位置
    // 但这种方法是无法定位每次跳到什么位置的
    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                count++;
            }
        }
        return count;
    }
}
